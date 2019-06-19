import { Component, OnInit } from '@angular/core';
import { CurrencyModel } from '../../shared/Currency.model'

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
  private getCurrenciesUrl = this.globals._url + 'admin/currencies';

  private newCar: boolean;
  private editCar: boolean;

  private currency: CurrencyModel;

  private currencies: CurrencyModel[];
  private carName: string;
  private pricePerDay: number;


  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private http: HttpClient,
              private globals: Globals,) { }

  ngOnInit() {
    this.newCar = true;
    this.editCar = false;

    this.getCurrencies();
  }

  newCarMethod() {
    this.newCar = true;
    this.editCar = false;
  }

  editCarMethod() {
    this.newCar = false;
    this.editCar = true;
  }


  getCurrencies() {
    this.http.get<[CurrencyModel]>(this.getCurrenciesUrl).subscribe(
      result => {
        this.currencies = result;
        console.log("Result : " + result);
      },
      error => {
        console.log("Error : " + error);
      }
    )
  }
}
