import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UpdateFlightComponent } from './update-flight.component';

const routes: Routes = [{ path: '', component: UpdateFlightComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UpdateFlightRoutingModule { }
