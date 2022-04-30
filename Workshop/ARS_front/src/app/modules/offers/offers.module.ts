import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OffersRoutingModule } from './offers-routing.module';
import { OffersComponent } from './offers.component';
import { AddDiscountComponent } from './offer-components/add-discount/add-discount.component';
import { UpdateDiscountComponent } from './offer-components/update-discount/update-discount.component';
import { DiscountListComponent } from './offer-components/discount-list/discount-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    OffersComponent,
    AddDiscountComponent,
    UpdateDiscountComponent,
    DiscountListComponent
  ],
  imports: [
    CommonModule,
    OffersRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatGridListModule,
    MatCardModule
  ]
})
export class OffersModule { }
