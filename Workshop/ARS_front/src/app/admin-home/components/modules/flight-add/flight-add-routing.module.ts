import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlightAddComponent } from './flight-add.component';

const routes: Routes = [{ path: '', component: FlightAddComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FlightAddRoutingModule { }
