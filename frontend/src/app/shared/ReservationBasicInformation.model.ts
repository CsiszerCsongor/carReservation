import { UpdateCarModel } from './UpdateCar.model';

export class ReservationBasicInformationModel {
  carname: string;
  startDate: string;
  endDate: string;
  sumOfReservation: number;
  reservationid: number;


  constructor(carname: string, startDate: string, endDate: string, sumOfReservation: number, reservationid: number) {
    this.carname = carname;
    this.startDate = startDate;
    this.endDate = endDate;
    this.sumOfReservation = sumOfReservation;
    this.reservationid = reservationid;
  }
}
