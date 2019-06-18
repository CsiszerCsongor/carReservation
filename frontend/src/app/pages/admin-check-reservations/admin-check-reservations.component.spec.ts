import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCheckReservationsComponent } from './admin-check-reservations.component';

describe('AdminCheckReservationsComponent', () => {
  let component: AdminCheckReservationsComponent;
  let fixture: ComponentFixture<AdminCheckReservationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCheckReservationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCheckReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
