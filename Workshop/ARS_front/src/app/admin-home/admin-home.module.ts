import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminHomeRoutingModule } from './admin-home-routing.module';
import { AdminHomeComponent } from './admin-home.component';
import { FlightListComponent } from './components/flight-list/flight-list.component';
import { HeaderComponent } from './components/header/header.component';
import { FormsModule } from '@angular/forms';
import { FlightByNameComponent } from './components/flight-by-name/flight-by-name.component';
import { FlightByDepartureComponent } from './components/flight-by-departure/flight-by-departure.component';




@NgModule({
  declarations: [
    AdminHomeComponent,
    FlightListComponent,
    HeaderComponent,
    FlightByNameComponent,
    FlightByDepartureComponent
    
  
   
  ],
  imports: [
    CommonModule,
    AdminHomeRoutingModule,
    FormsModule
  ]
})
export class AdminHomeModule { }
