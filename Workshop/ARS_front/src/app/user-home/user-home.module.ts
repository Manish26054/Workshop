import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserHomeRoutingModule } from './user-home-routing.module';
import { UserHomeComponent } from './user-home.component';
import { UserHeaderComponent } from './userComponents/user-header/user-header.component';
import { UserProfileComponent } from './userComponents/user-profile/user-profile.component';
import { UserFeedbackComponent } from './userComponents/user-feedback/user-feedback.component';
import { UserComplainComponent } from './userComponents/user-complain/user-complain.component';
import { UserSearchComponent } from './userComponents/user-search/user-search.component';
import { UserBookingsComponent } from './userComponents/user-bookings/user-bookings.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BookingFormComponent } from './userComponents/booking-form/booking-form.component';
import { MatButtonModule } from '@angular/material/button';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';


@NgModule({
  declarations: [
    UserHomeComponent,
    UserHeaderComponent,
    UserProfileComponent,
    UserFeedbackComponent,
    UserComplainComponent,
    UserSearchComponent,
    UserBookingsComponent,
    BookingFormComponent
  ],
  imports: [
    CommonModule,
    UserHomeRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatGridListModule,
    MatCardModule
  ]
})
export class UserHomeModule { }
