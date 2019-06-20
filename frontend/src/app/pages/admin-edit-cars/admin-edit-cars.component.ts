import { Component, OnInit } from '@angular/core';
import { CurrencyModel } from '../../shared/Currency.model'
import { CarModel } from '../../shared/Car.model'

import {TokenStorageService} from '../../auth/token-storage.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Globals} from '../../globals';

@Component({
  selector: 'app-admin-edit-cars',
  templateUrl: './admin-edit-cars.component.html',
  styleUrls: ['./admin-edit-cars.component.css']
})
export class AdminEditCarsComponent implements OnInit {
  private getCurrenciesUrl = this.globals._url + 'admin/currency/currencies';
  private carUrl = this.globals._url + 'admin/car/';

  private newCarComponentCanAppear: boolean;
  private editCarComponentCanAppear: boolean;
  private detailsCanAppear: boolean;
  private cursorFocus: boolean;
  private carCode: string;
  private carCreated: boolean;
  private carNotCreated: boolean;

  private carCodeAfterCreation: string;
  private currency: string;

  private currencies: CurrencyModel[];
  private carName: string;
  private pricePerDay: number;
  private car: CarModel;

  private newCar: CarModel;


  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private http: HttpClient,
              private globals: Globals,) { }

  ngOnInit() {
    this.newCarComponentCanAppear = true;
    this.editCarComponentCanAppear = false;
    this.carCode = "";
    this.detailsCanAppear = true;
    this.cursorFocus = false;
    this.carCreated = false;
    this.carNotCreated = true;
    this.carCodeAfterCreation = '';
    this.getCurrencies();
  }

  newCarMethod() {
    this.newCarComponentCanAppear = true;
    this.editCarComponentCanAppear = false;
  }

  editCarMethod() {
    this.newCarComponentCanAppear = false;
    this.editCarComponentCanAppear = true;
  }

  getCurrencies() {
    this.http.get<[CurrencyModel]>(this.getCurrenciesUrl).subscribe(
      result => {
        this.currencies = result;
        console.log("Result : " + JSON.stringify(result));
      },
      error => {
        console.log("Error : " + error);
      }
    )
  }

  searchCar(){
    var tmpUrl = this.carUrl + this.carCode;
    console.log("Get car url : " + tmpUrl);
    this.http.get<CarModel>(tmpUrl).subscribe(
      result => {
        this.detailsCanAppear = true;
        this.car = result;
      },
      error => {
        console.log(error);
      }
      
    )
  }

  checkPrice(){
    if(this.pricePerDay !== undefined){

      if(this.pricePerDay > 500){
        this.pricePerDay = 500;
      }
      if(this.pricePerDay < 0){
        this.pricePerDay = 0;
      }

      if(isNaN(this.pricePerDay) || this.pricePerDay === null){     // if contains e, than this.pricePerDay will be null
        this.pricePerDay = 0;
      }
      else if(this.pricePerDay !== 0) {
        
        var number = parseInt(this.pricePerDay.toString().replace(/^0+/, ''));
        this.pricePerDay = number;
      }
    }
  }

  createNewCar() {
    var tmp: CurrencyModel;
    var BreakException = {};

    try {
      this.currencies.forEach((e) => {
        if(e.name === this.currency) {
          tmp = e;
          throw BreakException;
        }
      });
    } catch (e) {
      if (e !== BreakException) throw e;
    }

    this.newCar = new CarModel(0,this.carName, this.pricePerDay, true, tmp, '');
    this.http.post<CarModel>(this.carUrl, this.newCar).subscribe(
      result => {
        console.log(JSON.stringify(result));
        this.newCar = result
        console.log("Car: " + JSON.stringify(this.newCar))
        this.carCodeAfterCreation = this.newCar.carCode;
        this.carCreated = true;
        this.carNotCreated = true;            // car was not created is true => error message don't need to appear
      },
      error => {
        this.carCreated = false;
        this.carNotCreated = false;           // car was not created is false  => error message need to be appear
        console.log(error);
      }
    );
  }
}
