import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item } from "../Components/shopping-page/Item";
import { Router } from '@angular/router';
import { Cart } from '../Components/cart';
import { BehaviorSubject } from 'rxjs';
import { Headers} from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient, private route: Router) { }

  public cart: Cart[]=[];
  public grandTotal: number;
  public noOfItems: number;
  public isCheckedOut: boolean = false;

  
  private messageSource = new BehaviorSubject<number>(0)
  currentMessage = this.messageSource.asObservable();

  changeMessage(message: number){
    this.messageSource.next(message)
  }

  private theCart = new BehaviorSubject<Cart[]>([]);
  currentCart = this.theCart.asObservable();

  changeCart(cart: Cart[]){
    this.theCart.next(cart)
  }

  private checkoutTotal = new BehaviorSubject<number>(0)
  currentCheckoutTotal = this.checkoutTotal.asObservable();

  changeCheckoutTotal(message: number){
    this.checkoutTotal.next(message)
  }

  getAllItems(){
    return this.http.get<Item[]>('http://localhost:8080/products')
  }

  getProductsView(){
    return this.http.get<Item[]>('http://localhost:8080/products/view')
  }

 basicAuthentication(userName, password){
   if(userName==="dummy"){
          this.route.navigate(['search-items'])
          sessionStorage.setItem('AuthenticatedUser', userName)
        }
  else
          return
 }

 isUserLoggedIn(){
  if(sessionStorage.getItem('AuthenticatedUser')===null)
    return false;
  else
    return true;
 }

 isUserCheckedOut(){
   return this.isCheckedOut
 }

 checkoutService(cart, grandTotal, isCheckedOut){
    this.cart = cart;
    this.grandTotal = grandTotal;
    this.isCheckedOut = isCheckedOut
 }
 
 cartItemsQty(noOfItems){
  this.noOfItems = noOfItems
 }

//  chargeCard(token: string) {
//    const headers = new Headers({'token': token, 'amount': 100});
//   this.http.post('http://localhost:8080/payment/charge', {}, {headers: headers})
//   }
}
