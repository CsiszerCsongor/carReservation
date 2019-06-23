import { Component, OnInit } from '@angular/core';
import {ReservationBasicInformationModel} from '../../shared/ReservationBasicInformation.model';
import {TokenStorageService} from '../../auth/token-storage.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Globals} from '../../globals';
import {ReservationInformationModel} from '../../shared/ReservationInformation.model';

@Component({
  selector: 'app-admin-check-reservations',
  templateUrl: './admin-check-reservations.component.html',
  styleUrls: ['./admin-check-reservations.component.css']
})
export class AdminCheckReservationsComponent implements OnInit {
  private getReservationBasicInformationList = this.globals._url + "admin/reservations/";
  private getReservationData = this.globals._url + "admin/reservations/";
  private acceptReservationUrl = this.globals._url + "admin/reservations/accept/";
  private declineReservationUrl = this.globals._url + "admin/reservations/decline/";

  private reservationList: ReservationBasicInformationModel[];
  private reservationData: ReservationInformationModel;
  private nrOfDays: number;
  private tmpid: number;
  private detailsCanAppear: boolean;

  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private http: HttpClient,
              private globals: Globals) { }

  ngOnInit() {
    this.detailsCanAppear = false;
    console.log(this.getReservationBasicInformationList);
    this.http.get<ReservationBasicInformationModel[]>(this.getReservationBasicInformationList).subscribe(
      result => {
          this.reservationList = result;

      }, error => {
        console.log(error);
      }
    )
  }

  showDetails(id: number) {
    this.tmpid = id;
    const tmpUrl = this.getReservationData + id;
    console.log(tmpUrl);
    this.http.get<ReservationInformationModel>(tmpUrl).subscribe(
      result => {
        console.log(JSON.stringify(result));
        this.reservationData = result;
        var date1 = new Date(this.reservationData.startDate);
        var date2 = new Date(this.reservationData.endDate);
        const diffTime = Math.abs(date2.getTime() - date1.getTime());
        this.nrOfDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24)) + 1;
        console.log(JSON.stringify(this.reservationData));
      },
      error => {
        console.log(error);
      }
    )
    this.detailsCanAppear = true;
  }

  back(){
    this.detailsCanAppear = false;
  }

  accept(){
    const tmpUrl = this.acceptReservationUrl + this.tmpid;
    this.http.get<boolean>(tmpUrl).subscribe(
      data => {

      },
      error => {
        console.log(error);
      }
    )
  }

  decline(){
    const tmpUrl = this.declineReservationUrl + this.tmpid;
    this.http.get<boolean>(tmpUrl).subscribe(
      data => {

      },
      error => {
        console.log(error);
      }
    )
  }

}
