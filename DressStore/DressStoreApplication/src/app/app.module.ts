import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShoppingPageComponent } from './Components/shopping-page/shopping-page.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './Components/header/header.component';
import { ItemSearchComponent } from './Components/item-search/item-search.component';
import { LoginComponent } from './Components/login/login.component';
import { CartTotalComponent } from './Components/cart-total/cart-total.component';
import { CheckoutComponent } from './Components/checkout/checkout.component';
import { ItemsComponent } from './Components/items/items.component';
import {HttpModule} from "@angular/http";
import { StripeModule } from "stripe-angular";
import { PaymentInfoComponent } from './Components/payment-info/payment-info.component';
import { PaymentErrorComponent } from './Components/payment-error/payment-error.component';

@NgModule({
  declarations: [
    AppComponent,
    ShoppingPageComponent,
    HeaderComponent,
    ItemSearchComponent,
    LoginComponent,
    CartTotalComponent,
    CheckoutComponent,
    ItemsComponent,
    PaymentInfoComponent,
    PaymentErrorComponent,
  ],
  imports: [
    BrowserModule, 
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    HttpModule
    //,StripeModule.forRoot("pk_test_lLwo40y7I78JHYMqBoUFH51g00yTjqUJ2a") 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
