import { Injectable } from '@angular/core';
import {HttpHeaders} from '@angular/common/http';

@Injectable()
export class Admin {
    username: string = "admin";
    password: string = "admin";
}
