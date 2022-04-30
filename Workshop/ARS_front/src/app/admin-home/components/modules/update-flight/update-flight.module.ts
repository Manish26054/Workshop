import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UpdateFlightRoutingModule } from './update-flight-routing.module';
import { UpdateFlightComponent } from './update-flight.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    UpdateFlightComponent
  ],
  imports: [
    CommonModule,
    UpdateFlightRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class UpdateFlightModule { }
