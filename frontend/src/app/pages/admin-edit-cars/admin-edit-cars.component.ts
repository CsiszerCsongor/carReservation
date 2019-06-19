import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-edit-cars',
  templateUrl: './admin-edit-cars.component.html',
  styleUrls: ['./admin-edit-cars.component.css']
})
export class AdminEditCarsComponent implements OnInit {

  private newCar: boolean;
  private editCar: boolean;

  constructor() { }

  ngOnInit() {
    this.newCar = true;
    this.editCar = false;
  }

  newCarMethod() {
    this.newCar = true;
    this.editCar = false;
  }

  editCarMethod() {
    this.newCar = false;
    this.editCar = true;
  }
}
