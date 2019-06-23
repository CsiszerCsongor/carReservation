import { CurrencyModel } from './Currency.model';
import { UpdateCarModel } from './UpdateCar.model';

export class PageableModel {
    cars: UpdateCarModel[];
    numberOfElements: number;
    nrOfPages: number;

  
    constructor(cars: UpdateCarModel[], numberOfElements: number, nrOfPages: number) {
      this.cars = cars;
      this.numberOfElements = numberOfElements;
      this.nrOfPages = nrOfPages;
    }
  }