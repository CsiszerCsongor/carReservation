import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEditCarsComponent } from './admin-edit-cars.component';

describe('AdminEditCarsComponent', () => {
  let component: AdminEditCarsComponent;
  let fixture: ComponentFixture<AdminEditCarsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminEditCarsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminEditCarsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
