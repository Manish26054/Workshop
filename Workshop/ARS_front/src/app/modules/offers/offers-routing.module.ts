import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UpdateDiscountComponent } from './offer-components/update-discount/update-discount.component';
import { OffersComponent } from './offers.component';

const routes: Routes = [{ path: '', component: OffersComponent },
{path:'editDiscount/:id',component:UpdateDiscountComponent},];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OffersRoutingModule { }
