import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { DataService } from 'src/app/Service/data.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Item } from './Item';
import { Cart } from '../cart';

@Component({
  selector: 'app-shopping-page',
  templateUrl: './shopping-page.component.html',
  styleUrls: ['./shopping-page.component.css']
})

export class ShoppingPageComponent implements OnInit, OnChanges{

  constructor(private dataService: DataService, private route: ActivatedRoute, private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;

   }
  

  searchedItems: Item[];
  search: any;
  cart: Cart[] = [];
  tempCart: Cart;
  splitStr: string;
  count: number = 0;
  inTheCart: boolean = false;
  grandTotal: number = 0;

 ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
    this.calcGrandTotal(this.cart)
  }

  ngOnInit() {

        this.dataService.getProductsView().subscribe(response => (this.searchedItems = response));
      }

  addtoCart(item){

    if(this.dataService.isUserLoggedIn()){
         this.inTheCart = this.searchCart(this.cart, item)
      //    if(this.inTheCart){
      //     console.log("Item is in the cart!")
      //   this.count = this.count + 1;
      //    for(let i=0; i<this.cart.length; i++){
      //     if(this.cart[i].id===item.id){
      //       this.cart[i].noOfItems = this.tempCart.noOfItems + this.count;
      //       this.cart[i].subTotal = this.count * item.price
      //       console.log("Item Qty updated in the cart!")
      //       return;
      //     }
      //   }
      //   this.count = 0;
      //   return;
      // }
     if(this.inTheCart===false){    
        this.tempCart  = new Cart();  
         this.count = this.count + 1;
         this.tempCart.id = item.id;
         this.tempCart.name = item.name;
         this.tempCart.noOfItems = this.count;
         this.tempCart.price = item.price;
         this.tempCart.subTotal = this.count * item.price
       this.cart.push(this.tempCart)
       this.count = 0;
       console.log("New item is added in the cart!")
       this.grandTotal = this.calcGrandTotal(this.cart)
        return;
      }
    }
    if(!this.dataService.isUserLoggedIn()){
        this.router.navigateByUrl('login')
        return;
      }
  }

  searchItem(search){
    this.titleCase(search)
        if(this.splitStr===null)
          return
        else
          this.searchedItems = this.searchedItems.filter((item) => item.name.startsWith(this.splitStr))
    }

  titleCase(str) {
    var splitStr = str.toLowerCase().split(' ');
    for (var i = 0; i < splitStr.length; i++) {
        // You do not need to check if i is larger than splitStr length, as your for does that for you
        // Assign it back to the array
          splitStr[i] = splitStr[i].charAt(0).toUpperCase() + splitStr[i].substring(1);
      }
      // Directly return the joined string
      this.splitStr = splitStr.join(' ')
      return this.splitStr;
    }

    searchCart(cart, item){
      if(cart === undefined || cart.length == 0){
        return false;
      }
      this.cartSearch(item)
    }

    cartSearch(item){
      for(let i=0; i<this.cart.length; i++){
          if(this.cart[i].id===item.id){
            console.log("Item is found by (cartSearch) in the cart!")
            this.cart[i].noOfItems = this.cart[i].noOfItems + 1;
            this.cart[i].subTotal = this.cart[i].noOfItems * this.cart[i].price
              this.inTheCart = true
              console.log("current item id: "+item.id)
              this.calcGrandTotal(this.cart)

              return 
        }
      }
        if(!this.inTheCart){
              console.log("Item is not found by (cartSearch) in the cart!")
              let tempCart: Cart = new Cart();  
  
             tempCart.id = item.id;
             tempCart.name = item.name;
             tempCart.noOfItems = 1;
             tempCart.price = item.price;
             tempCart.subTotal = item.price
             this.cart.push(tempCart)
             this.calcGrandTotal(this.cart)

             return 
        }
    }

    calcGrandTotal(cart){
      let grandTotal;
      for(let i=0; i<cart.length; i++){
        grandTotal = grandTotal + cart.subTotal 
      }
      console.log("*-* "+grandTotal)
      return grandTotal
    }

  //   grandTotalCalc(cart: Cart[]){
  //     for(let i=0; i<cart.length; i++){
  //      this.grandTotal+=cart[i].subTotal
  //    }
  //  }
 }


