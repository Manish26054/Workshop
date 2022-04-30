import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UpdateDiscountComponent } from './modules/offers/offer-components/update-discount/update-discount.component';
import { OffersComponent } from './modules/offers/offers.component';





const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./flight-home/flight-home.module').then(m => m.FlightHomeModule)
  },
  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then(m => m.LoginModule)
  },
 
  {
    path:'adminHome',
    loadChildren:()=>import('./admin-home/admin-home.module').then(m=>m.AdminHomeModule)
  },
  
  { 
    path: 'userHome', 
    loadChildren: () => import('./user-home/user-home.module').then(m => m.UserHomeModule) 
  },
 
  { path: '', redirectTo: '/home', pathMatch: 'full' },
 
  
  
  //  {path:'editDiscount/:id',component:UpdateDiscountComponent},
  //  {path:'offers',component:OffersComponent},
   

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
