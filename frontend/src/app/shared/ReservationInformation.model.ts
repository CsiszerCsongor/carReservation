import { UpdateCarModel } from './UpdateCar.model';

export class ReservationInformationModel {
    car: UpdateCarModel;
    page: string;
    
    constructor(car: UpdateCarModel, page: string) {
        this.car = car;
        this.page = page;
    }
  }