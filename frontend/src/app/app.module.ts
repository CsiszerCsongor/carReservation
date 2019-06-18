import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { httpInterceptorProviders } from './auth/auth-interceptor';
import { MainPageComponent } from './main-page/main-page.component';
import { Globals } from './globals';
import { ConfigService } from './services/config';
import { UserMainpageComponent } from './pages/user-mainpage/user-mainpage.component';
import { AdminCheckReservationsComponent } from './pages/admin-check-reservations/admin-check-reservations.component';
import { AdminEditCarsComponent } from './pages/admin-edit-cars/admin-edit-cars.component'

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    MainPageComponent,
    UserMainpageComponent,
    AdminCheckReservationsComponent,
    AdminEditCarsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  entryComponents: [
    UserMainpageComponent,
    AdminCheckReservationsComponent,
    AdminEditCarsComponent
  ],
  providers: [httpInterceptorProviders, Globals, ConfigService],
  bootstrap: [AppComponent]
})
export class AppModule { }
