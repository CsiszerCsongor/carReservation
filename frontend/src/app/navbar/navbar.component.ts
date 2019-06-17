import { Component, OnInit, Output } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service.1';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Globals } from '../globals';
import { EventEmitter } from '@angular/core';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.sass']
})
export class NavbarComponent implements OnInit {
  authority: string;
  roles: string[];

  @Output() MessageEvent = new EventEmitter<string>();

  constructor(private tokenStorage: TokenStorageService,
              private router: Router,
              private http: HttpClient,
              private globals: Globals) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if(role == "ROLE_ADMIN") {
          this.authority = 'admin';
          return false;
        }
        else {
          this.authority = 'user';
          return true;
        }
      });
    }
  }

  sendPage(page: string){
    this.MessageEvent.emit(page);
  }

  logout() {
    this.tokenStorage.signOut();
    this.router.navigateByUrl('/main');
  }

}
