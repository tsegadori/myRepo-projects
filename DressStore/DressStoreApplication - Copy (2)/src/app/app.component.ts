import { Component, OnInit, Input, ViewChild, AfterViewInit, ElementRef } from '@angular/core';
import { CartTotalComponent } from './Components/cart-total/cart-total.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit{
  
  title = 'DressStoreApplication';
  public searchQuery = '';
  public cartItemsQty: number = 0;
  @Input() public searchData;
 
  constructor(){}
  
  @ViewChild(CartTotalComponent) cartTotalComponent: CartTotalComponent;
  
  ngAfterViewInit() {
      this.getCarQty()
      
	} 
 
  getCarQty(){
  //  console.log("printed from App Comp: "+this.cartTotalComponent.noOfItems)
  }

  ngOnInit(){
  }
}
