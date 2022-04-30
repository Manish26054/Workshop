import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightByNameComponent } from './flight-by-name.component';

describe('FlightByNameComponent', () => {
  let component: FlightByNameComponent;
  let fixture: ComponentFixture<FlightByNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightByNameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightByNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
