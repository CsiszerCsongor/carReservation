import { UpdateCarModel } from './UpdateCar.model';

export class UserModel {
    name: string;
    email: string;
    address: string;
    telephone: string;
    startDate: string;
    endDate: string;
    sumOfReservation: number;
    carid: number;
    currency: string;
    
    constructor(name: string, email: string, address: string, telephone: string, startDate: string, endDate: string, sumOfReservation: number, 
                carid: number, currecncy: string) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sumOfReservation = sumOfReservation;
        this.carid = carid;
        this.currency = currecncy;
    }
  }