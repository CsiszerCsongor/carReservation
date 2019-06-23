import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import {TokenStorageService} from '../auth/token-storage.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Globals} from '../globals';

import { UserMainpageComponent } from '../pages/user-mainpage/user-mainpage.component'
import { AdminCheckReservationsComponent } from '../pages/admin-check-reservations/admin-check-reservations.component'
import { AdminEditCarsComponent } from '../pages/admin-edit-cars/admin-edit-cars.component'

import { ComponentMessageModel } from '../shared/ComponentMessage.model'


@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  private messageFromParent: ComponentMessageModel;

  private actualPage: string;
  private actualComponent: any;

  private authority: string;
  private role: string[];

  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private http: HttpClient,
              private globals: Globals) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.role = this.tokenStorage.getAuthorities();
      this.role.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        }
      });
    }
    else {
      this.authority = 'user';
    }

    if (this.authority === 'user') {
      this.actualComponent = UserMainpageComponent;
    }
    else {
      this.actualComponent = AdminCheckReservationsComponent;
    }
  }

  receivePage($event) {
    this.messageFromParent = $event;

    this.actualPage = this.messageFromParent.page;
    this.authority = this.messageFromParent.authority;

    if(this.actualPage === 'Belepes') {
      this.actualPage = 'Foglalasok';
    }

    if (this.actualPage === 'Kilepes') {
      this.actualPage = 'Kereses';
    }

    

    if(this.authority === 'user') {
      if (this.actualPage === 'Kereses') {
        this.authority = 'user';
        this.actualComponent = UserMainpageComponent;
      }
    }
    else {
      if(this.authority === 'admin') {
        if (this.actualPage == 'Foglalasok') {
          this.actualComponent = AdminCheckReservationsComponent;
        }
        else if (this.actualPage === 'Szerkesztes') {
          this.actualComponent = AdminEditCarsComponent;
        }
      }
    }
  }

}
