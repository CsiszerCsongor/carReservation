import { UpdateCarModel } from './UpdateCar.model';

export class ReservationInformationModel {
    name: string;
    email: string;
    telephone: string;
    address: string;
    sumOfReservation: number;
    carName: string;
    pricePerDay: number;
    carCode: string;
    currency: string;
    startDate: string;
    endDate: string;


  constructor(name: string, email: string, telephone: string, address: string, sumOfReservation: number, carName: string, pricePerDay: number,
              carCode: string, currency: string, startDate: string, endDate: string) {
    this.name = name;
    this.email = email;
    this.telephone = telephone;
    this.address = address;
    this.sumOfReservation = sumOfReservation;
    this.carName = carName;
    this.pricePerDay = pricePerDay;
    this.carCode = carCode;
    this.currency = currency;
    this.startDate = startDate;
    this.endDate = endDate;
  }
}
