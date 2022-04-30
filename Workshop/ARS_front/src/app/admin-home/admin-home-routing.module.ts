import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { AdminHomeComponent } from './admin-home.component';
import { FlightListComponent } from './components/flight-list/flight-list.component';
import { FlightAddComponent } from './components/modules/flight-add/flight-add.component';
import { UpdateFlightComponent } from './components/modules/update-flight/update-flight.component';




const routes: Routes = [{ path: '', component: AdminHomeComponent ,
children:[
 { path: 'addFlight', loadChildren: () => import('./components/modules/flight-add/flight-add.module').then(m => m.FlightAddModule) },
 { path: 'bookings', loadChildren: () => import('./components/modules/bookings/bookings.module').then(m => m.BookingsModule) },
 {path:'flightList',component:FlightListComponent},
 { path: 'complaints', loadChildren: () => import('./components/modules/complaints/complaints.module').then(m => m.ComplaintsModule) },
 { path: 'reports', loadChildren: () => import('./components/modules/reports/reports.module').then(m => m.ReportsModule) },
 { path: 'offers', loadChildren: () => import('../modules/offers/offers.module').then(m => m.OffersModule) },
 { path: 'edit/:id', loadChildren: () => import('./components/modules/update-flight/update-flight.module').then(m => m.UpdateFlightModule) },
{path:'',redirectTo:'login/adminHome/flightList',pathMatch:'full'},
{path:'editFlight/:id',component:UpdateFlightComponent},
{ path: 'feedback', loadChildren: () => import('./components/modules/feedback/feedback.module').then(m => m.FeedbackModule) },
]},

// {path:'editFlight/:id',component:UpdateFlightComponent},
// {path:'flightList',component:FlightListComponent},


];






@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminHomeRoutingModule { }
