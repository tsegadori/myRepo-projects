import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemSearchComponent } from './Components/item-search/item-search.component';
import { LoginComponent } from './Components/login/login.component';
import { CheckoutComponent } from './Components/checkout/checkout.component';
import { ItemsComponent } from './Components/items/items.component';
import { PaymentInfoComponent } from './Components/payment-info/payment-info.component';
import { PaymentErrorComponent } from './Components/payment-error/payment-error.component';

const routes: Routes = [
  {path: "", component: ItemsComponent},
  {path: "search-items", component: ItemsComponent},
  {path: "login", component: LoginComponent},
  {path: "search-items/:item", component: ItemsComponent},
  {path: "checkout", component: CheckoutComponent},
  {path: "payment", component: PaymentInfoComponent},
  {path: "payment-error", component: PaymentErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
