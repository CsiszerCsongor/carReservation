import { Component, OnInit } from '@angular/core';
import { CarModel } from 'src/app/shared/Car.model';

import {TokenStorageService} from '../../auth/token-storage.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Globals} from '../../globals';

import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { PageableModel } from 'src/app/shared/Pageable.model';

import { TwoDateOnePageModel } from 'src/app/shared/TwoDateOnePage.model'
import { UpdateCarModel } from 'src/app/shared/UpdateCar.model';

@Component({
  selector: 'app-user-mainpage',
  templateUrl: './user-mainpage.component.html',
  styleUrls: ['./user-mainpage.component.css']
})
export class UserMainpageComponent implements OnInit {
  private getCarsBetweenDatesUrl = this.globals._url + "user/cars";

  private cars: UpdateCarModel[];
  datePickerConfig: Partial<BsDatepickerConfig>;

  private pagebleModel: PageableModel;
  private twoDatePageModel: TwoDateOnePageModel;

  private todayDate = new Date();
  private daterangepickerModel: Date[];

  private nrOfElementsOnPage = 5;
  private pageNumber:number;                //all page number
  private actualPageNumber: number;         //actual page number
  

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

}


