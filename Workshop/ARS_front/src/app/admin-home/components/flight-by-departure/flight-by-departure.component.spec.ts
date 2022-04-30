import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightByDepartureComponent } from './flight-by-departure.component';

describe('FlightByDepartureComponent', () => {
  let component: FlightByDepartureComponent;
  let fixture: ComponentFixture<FlightByDepartureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightByDepartureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightByDepartureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
