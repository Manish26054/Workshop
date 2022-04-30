import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FlightAddRoutingModule } from './flight-add-routing.module';
import { FlightAddComponent } from './flight-add.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    FlightAddComponent
  ],
  imports: [
    CommonModule,
    FlightAddRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class FlightAddModule { }
