import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemSearchComponent } from './Components/item-search/item-search.component';
import { LoginComponent } from './Components/login/login.component';
import { CheckoutComponent } from './Components/checkout/checkout.component';

const routes: Routes = [
  {path: "", component: ItemSearchComponent},
  {path: "search-items", component: ItemSearchComponent},
  {path: "login", component: LoginComponent},
  {path: "search-items/:item", component: ItemSearchComponent},
  {path: "checkout", component: CheckoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
