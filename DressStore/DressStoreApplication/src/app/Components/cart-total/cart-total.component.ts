import { Component, OnInit, Input, OnChanges, ElementRef, ViewChild, Output } from '@angular/core';
import { Cart } from '../cart';
import { Router } from '@angular/router';
import { DataService } from 'src/app/Service/data.service';
import { EventEmitter } from 'protractor';

@Component({
  selector: 'app-cart-total',
  templateUrl: './cart-total.component.html',
  styleUrls: ['./cart-total.component.css']
})
export class CartTotalComponent implements OnInit, OnChanges{
 
  @Input() public total: number;
  @Input() public cart: Cart[] = [];
  public grandTotal: number = 0;
  public myCart: Cart[] = [];
  public noOfItems:number = 0;
  public temp:number = 0;
  public isCheckedOut: boolean = false

  ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
    this.dataService.currentCart.subscribe(data => {this.myCart = data})
    this.noOfItems = this.cart.length
    this.dataService.changeMessage(this.noOfItems)
    
  }

  constructor(private router: Router, private dataService: DataService) {
   // this.router.routeReuseStrategy.shouldReuseRoute = () => false;
   }
 

  ngOnInit() {
    this.dataService.currentCheckoutTotal.subscribe(message => 
      {this.grandTotal = message})
    this.noOfItems = 0;
    this.temp = 0;
    this.isCheckedOut = this.dataService.isCheckedOut
  }

  checkOut(){
    let isCheckedOut = true
    this.router.navigate(['/checkout'])
    this.checkoutRouting(this.myCart, this.grandTotal, isCheckedOut)
    
  }

  checkoutRouting(myCart, grandTotal, isCheckedOut){
     this.dataService.checkoutService(myCart, grandTotal, isCheckedOut)
  }

  
 
}
