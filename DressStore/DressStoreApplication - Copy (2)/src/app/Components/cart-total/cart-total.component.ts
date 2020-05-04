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
  public noOfItems;
  public temp:number = 0;
  

  ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
    this.myCart = this.cart
    this.grandTotal = this.total
    this.noOfItems = this.cart.length
    this.cartItemsQty()
    console.log(this.noOfItems)
    this.dataService.changeMessage(this.noOfItems)
  }

  constructor(private router: Router, private dataService: DataService) { }
 

  ngOnInit() {
    this.noOfItems = 0;
    this.temp = 0;
    
  }

  checkOut(){
    this.router.navigate(['/checkout'])
    this.checkoutRouting(this.myCart, this.grandTotal, this.noOfItems)
  }

  checkoutRouting(myCart, grandTotal, noOfItems){
     this.dataService.checkoutService(myCart, grandTotal, myCart.length)
  }

  cartItemsQty(){
    let temp = 0
    for(let i=0; i<this.myCart.length; i++){
      temp = temp + this.myCart[i].noOfItems
    }
    this.noOfItems = temp
  }
 
}
