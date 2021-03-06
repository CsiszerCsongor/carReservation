import { CurrencyModel } from './Currency.model';

export class CarModel {
    id: number;
    name: string;
    pricePerDay: number;
    active: boolean;
    currency: CurrencyModel;
    carCode: string;
  
    constructor(id: number, name: string, pricePerDay: number, active: boolean, currency: CurrencyModel, carCode: string) {
      this.id = id;
      this.name = name;
      this.pricePerDay = pricePerDay;
      this.active = active;
      this.currency = currency;
      this.carCode = carCode;
    }
  }