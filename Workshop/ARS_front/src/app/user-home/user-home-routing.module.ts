import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserHomeComponent } from './user-home.component';
import { BookingFormComponent } from './userComponents/booking-form/booking-form.component';
import { UserBookingsComponent } from './userComponents/user-bookings/user-bookings.component';
import { UserComplainComponent } from './userComponents/user-complain/user-complain.component';
import { UserFeedbackComponent } from './userComponents/user-feedback/user-feedback.component';
import { UserProfileComponent } from './userComponents/user-profile/user-profile.component';
import { UserSearchComponent } from './userComponents/user-search/user-search.component';

const routes: Routes = [{ path: '', component: UserHomeComponent ,
children:[
  {path:"userSearch",component:UserSearchComponent},
  {path:"userProfile",component:UserProfileComponent},
  {path:"userFeedback",component:UserFeedbackComponent},
  {path:"userComplain",component:UserComplainComponent},
  {path:"userBooking",component:UserBookingsComponent},
  {path:'bookingForm/:id',component:BookingFormComponent},
  {path:'',redirectTo:'login/userHome/userSearch',pathMatch:'full'},



]
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserHomeRoutingModule { }
