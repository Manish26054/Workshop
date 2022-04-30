import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FlightHomeRoutingModule } from './flight-home-routing.module';
import { FlightHomeComponent } from './flight-home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    FlightHomeComponent
  ],
  imports: [
    CommonModule,
    FlightHomeRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class FlightHomeModule { }
