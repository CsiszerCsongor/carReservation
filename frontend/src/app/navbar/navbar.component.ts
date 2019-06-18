import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../auth/token-storage.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Globals} from '../globals';
import { Output, EventEmitter } from '@angular/core';
import {AuthLoginInfo} from '../auth/login-info';
import {AuthService} from '../auth/auth.service';

import { ConfigService } from '../services/config'

import { ComponentMessageModel } from '../shared/ComponentMessage.model'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  private authority: string;
  private roles: string[];

  private loginInfo: AuthLoginInfo;
  private adminConfig: any;

  private isLoggedIn = false;
  private isLoginFailed = false;
  private errorMessage = '';

  private componentMessage: ComponentMessageModel;

  @Output() messageEvent = new EventEmitter<ComponentMessageModel>();

  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private http: HttpClient,
              private globals: Globals,
              private configService: ConfigService,
              private authService: AuthService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        }
        this.authority = 'user';
        return true;
      });
    }
    else {
      this.authority = 'user';
    }

    this.componentMessage = new ComponentMessageModel();
  }

  sendPage(page: string) {
    this.componentMessage.page = page;
    this.componentMessage.authority = this.authority;
    console.log("Component message event: " + this.componentMessage)
    this.messageEvent.emit(this.componentMessage);
  }

  login() {
    this.adminConfig = this.configService.loadJSON('./assets/admin.json')
  
    this.loginInfo = new AuthLoginInfo(
      this.adminConfig.username,
      this.adminConfig.password
    );

    this.authService.attemptAuth(this.loginInfo).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getAuthorities();
        this.authority = 'admin';
        this.sendPage('Belepes')
      },
      error => {
        console.log(error);
        this.errorMessage = error.message;
        this.isLoginFailed = true;
      }
    )
  }

  logout() {
    this.tokenStorage.signOut();
    this.isLoggedIn = false;
    this.authority = 'user';
    this.sendPage('Kilepes')
  }

}
