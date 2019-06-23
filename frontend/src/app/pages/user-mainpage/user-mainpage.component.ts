import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { CarModel } from 'src/app/shared/Car.model';

import {TokenStorageService} from '../../auth/token-storage.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Globals} from '../../globals';

import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { PageableModel } from 'src/app/shared/Pageable.model';

import { TwoDateOnePageModel } from 'src/app/shared/TwoDateOnePage.model'
import { UpdateCarModel } from 'src/app/shared/UpdateCar.model';
import { UserModel } from 'src/app/shared/User.model';

@Component({
  selector: 'app-user-mainpage',
  templateUrl: './user-mainpage.component.html',
  styleUrls: ['./user-mainpage.component.css']
})
export class UserMainpageComponent implements OnInit {
  private getCarsBetweenDatesUrl = this.globals._url + "user/cars";
  private sendReservationUrl = this.globals._url + "user/reservation";

  private cars: UpdateCarModel[];
  datePickerConfig: Partial<BsDatepickerConfig>;

  private pagebleModel: PageableModel;
  private twoDatePageModel: TwoDateOnePageModel;

  private todayDate = new Date();
  private daterangepickerModel: Date[];

  private nrOfElementsOnPage = 5;
  private pageNumber:number;                //all page number
  private actualPageNumber: number;         //actual page number

  // ============================ Reserv car part ============================ 
  private reservationCanAppear: boolean;
  private choosedCar: UpdateCarModel;
  private user: UserModel;
  private startDateInNormalMode: string;
  private endDateInNormalMode: string;
  private twoDateDifference: number;
  private onlyLettersAndSpace = new RegExp(/^[A-Z][A-Za-z ]+$/);
  private onlyDigits = new RegExp(/^\d+$/);
  private invalidName: boolean;
  private invalidTelephone: boolean;
  private incorrectDatas: boolean;
  private submitButtonClicked: boolean;

  private emailRegexp = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
  private invalidEmail = false;
  

  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private http: HttpClient,
              private globals: Globals) {

                this.datePickerConfig = Object.assign({},
                  {containerClass: 'theme-dark-blue',
                  showWeekNumbers:false,
                  rangeInputFormat: 'YYYY-MM-DD',
                  rangeSeparator: '  :  '
                  });
               }

  ngOnInit() {
    var date1 = new Date();
    var date2 = new Date();
    this.daterangepickerModel = new Array();
    this.daterangepickerModel.push(date1)
    this.daterangepickerModel.push(date2)
    this.pageNumber = 0;
    this.reservationCanAppear = false;
    this.invalidEmail = false;
    this.invalidTelephone = false;
    this.submitButtonClicked = false;
  }

  arrayOne(n: number): any[] {
    return Array(n);
  }

  searchCarsBetweenDates() {
    var date1 = this.daterangepickerModel[0];
    var date2 = this.daterangepickerModel[1];

    this.twoDatePageModel = new TwoDateOnePageModel(date1, date2, 0, this.nrOfElementsOnPage);
    this.twoDatePageModel.page = 0;
    console.log("Two date page model : " + JSON.stringify(this.twoDatePageModel));
    this.http.post<PageableModel>(this.getCarsBetweenDatesUrl, this.twoDatePageModel).subscribe(
      result => {
        this.pagebleModel = result;
        this.cars = this.pagebleModel.cars;
        this.pageNumber = this.pagebleModel.nrOfPages;
        this.actualPageNumber = 0;
        console.log(JSON.stringify(this.cars));
      },
      error => {
        console.log(error)
      } 
    );
  }

  getPageItems(i: number) {
    if(i != -2 && i != -1){
      i = i - 1;
      var date1 = this.daterangepickerModel[0];
      var date2 = this.daterangepickerModel[1];
      this.actualPageNumber = i;
      this.getPagePostMethod(date1, date2);
    }
    else{ 
      if(i == -2) {           // previous button
          if(this.actualPageNumber >= 1){
            this.actualPageNumber = this.actualPageNumber - 1;
            var date1 = this.daterangepickerModel[0];
            var date2 = this.daterangepickerModel[1];
            this.getPagePostMethod(date1, date2);
          }
      }
      else{
        if(i == -1) {        // next button
          console.log("Actual page : " + this.actualPageNumber);
          console.log("Page number : " + this.pageNumber);
          if(this.actualPageNumber < this.pageNumber-1) {
            this.actualPageNumber = this.actualPageNumber + 1;
            var date1 = this.daterangepickerModel[0];
            var date2 = this.daterangepickerModel[1];
            this.getPagePostMethod(date1, date2);
          }
        }
      } 
    }
    console.log("Page number : " + i);
  }


  getPagePostMethod(date1: Date, date2: Date){
    console.log(this.actualPageNumber);
    this.twoDatePageModel = new TwoDateOnePageModel(date1, date2, this.actualPageNumber, this.nrOfElementsOnPage);
    this.twoDatePageModel.page = this.actualPageNumber;
    console.log("Two date page model : " + JSON.stringify(this.twoDatePageModel));
    this.http.post<PageableModel>(this.getCarsBetweenDatesUrl, this.twoDatePageModel).subscribe(
      result => {
        this.pagebleModel = result;
        this.cars = this.pagebleModel.cars;
        this.pageNumber = this.pagebleModel.nrOfPages;
        console.log(JSON.stringify(this.cars));
      },
      error => {
        console.log(error)
    });
  }

  reservCar(id:number){
    this.cars.forEach((item) => {
      if(item.id === id){
        this.choosedCar = item;
      }
    });

    this.user = new UserModel('','','','','','',0, id, this.choosedCar.currency);

    var tmp = JSON.stringify(this.daterangepickerModel[0]);
    this.startDateInNormalMode = tmp.substr(0, tmp.indexOf('T')).replace('"','');
    var tmp = JSON.stringify(this.daterangepickerModel[1]);
    this.endDateInNormalMode = tmp.substr(0, tmp.indexOf('T')).replace('"','');
    console.log(this.startDateInNormalMode);
    console.log(this.endDateInNormalMode);

    const diffTime = Math.abs(this.daterangepickerModel[1].getTime() - this.daterangepickerModel[0].getTime());
    this.twoDateDifference = Math.ceil(diffTime / (1000 * 60 * 60 * 24)) + 1; 
    console.log("Difference : " + this.twoDateDifference);
    
    this.reservationCanAppear = true;
  }


  backToList(){
    this.reservationCanAppear = false;
    this.submitButtonClicked = false;
  }

  checkName(){
    if (this.onlyLettersAndSpace.test(this.user.name)) {
      this.invalidName = false;
    } else {
      this.invalidName = true;
    }
  }

  checkEmail(){
    if (this.emailRegexp.test(this.user.email)) {
      this.invalidEmail = false;
    } else {
      this.invalidEmail = true;
    }
  }

  checkTelephone(){
    if (this.onlyDigits.test(this.user.telephone) && this.user.telephone.length == 10) {
      this.invalidTelephone = false;
    } else {
      this.invalidTelephone = true;
    }
  }

  submitRecerve() {
    if(this.invalidName || this.invalidEmail || this.invalidTelephone || 
       this.user.address === undefined || this.user.address === ''
      ) {
        this.submitButtonClicked = true;
        this.incorrectDatas = true;

    }
    else{
      this.user.startDate = this.startDateInNormalMode;
      this.user.endDate = this.endDateInNormalMode;
      this.user.sumOfReservation = this.twoDateDifference * this.choosedCar.pricePerDay;
      console.log("User data : " + JSON.stringify(this.user));

      this.http.post<boolean>(this.sendReservationUrl, this.user).subscribe(
        result => {
          if(result){
            if(result == true){
              this.submitButtonClicked = true;
              this.incorrectDatas = false;
            }
            else{
              this.submitButtonClicked = true;
              this.incorrectDatas = false;
            }
            
          }
        },
        error => {
          this.submitButtonClicked = true;
          this.incorrectDatas = true;
        }
      );
      
      
    }
  }
}
