import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item } from "../Components/shopping-page/Item";
import { Router } from '@angular/router';
import { Cart } from '../Components/cart';
import { BehaviorSubject } from 'rxjs';
 

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient, private route: Router) { }

  public cart: Cart[]=[];
  public grandTotal: number;
  public noOfItems: number;
  
  private messageSource = new BehaviorSubject<string>("0")
  currentMessage = this.messageSource.asObservable();

  changeMessage(message: string){
    this.messageSource.next(message)
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

 checkoutService(cart, grandTotal, noOfItems){
    this.cart = cart;
    this.grandTotal = grandTotal;
    this.noOfItems = noOfItems
 }
 
 cartItemsQty(noOfItems){
  this.noOfItems = noOfItems
 }
}
