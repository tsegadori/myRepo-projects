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

@NgModule({
  declarations: [
    AppComponent,
    ShoppingPageComponent,
    HeaderComponent,
    ItemSearchComponent,
    LoginComponent,
    CartTotalComponent,
    CheckoutComponent,
  ],
  imports: [
    BrowserModule, 
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
