import { Component, OnInit, OnChanges } from '@angular/core';
import { Item } from '../shopping-page/Item';
import { Cart } from '../cart';
import { DataService } from 'src/app/Service/data.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit, OnChanges {

  constructor(private dataService: DataService, private router: Router, private route: ActivatedRoute) { }
  
  ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
    this.calcGrandTotal(this.cart)
    this.dataService.changeCheckoutTotal(this.grandTotal)
  }

    searchedItems: Item[];
    search: any;
    cart: Cart[] = [];
    tempCart: Cart;
    splitStr: string;
    count: number = 0;
    inTheCart: boolean = false;
    total: number = 0;
    public noOfItems:number = 0;
    grandTotal: number = 0;
   
  ngOnInit() {
    this.route.params.subscribe((item) => {this.search = item, this.loadItems(this.search)})
         this.titleCase(this.search.item)
  }

  loadItems(search){
    if(search===null)
    this.dataService.getProductsView().subscribe(response => (this.searchedItems = response))
    else
    this.titleCase(this.search.item)
     this.dataService.getProductsView().subscribe(response => (this.searchedItems = response.filter
     ((item) => item.name.startsWith(this.splitStr)))) 
  }

addtoCart(item){
this.total = 0
if(this.dataService.isUserLoggedIn()){
     this.inTheCart = this.searchCart(this.cart, item)
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
     this.cartItemsQty(this.cart)

     if(this.cart.length===1){
     this.total+=this.cart[0].subTotal
     this.calcGrandTotal(this.cart)
     this.dataService.changeCheckoutTotal(this.grandTotal)
       }
         
   console.log("New item is added in the cart!")
   this.dataService.changeCart(this.cart)
      this.cartItemsQty(this.cart)
      this.calcGrandTotal(this.cart)
      this.dataService.changeCheckoutTotal(this.grandTotal)
    return;
  }
}
if(!this.dataService.isUserLoggedIn()){
    this.router.navigateByUrl('login')
    return;
  }
}

cartItemsQty(myCart){
  let temp = 0
  for(let i=0; i<myCart.length; i++){
    temp = temp + myCart[i].noOfItems
  }
  this.noOfItems = temp
  this.dataService.changeMessage(this.noOfItems)
}

searchItem(search){
this.titleCase(search)
    if(this.splitStr===null)
      return
    else
      this.searchedItems = this.searchedItems.filter((item) => item.name.startsWith(this.splitStr))
}

titleCase(str) {
if(str===undefined){
this.dataService.getProductsView().subscribe(response => (this.searchedItems = response))
return;
}
else
var splitStr = str.toLowerCase().split(' ');
for (var i = 0; i < splitStr.length; i++) {
    // You do not need to check if i is larger than splitStr length, as your for does that for you
    // Assign it back to the array
      splitStr[i] = splitStr[i].charAt(0).toUpperCase() + splitStr[i].substring(1);
  }
  // Directly return the joined string
  this.splitStr = splitStr.join(' ')
  this.dataService.getProductsView().subscribe(response => (this.searchedItems = response.filter
  ((item) => item.name.startsWith(this.splitStr)))) 
  return; 
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
        this.total = 0
        this.totalCalculator(this.cart)
        console.log("current item id: "+item.id)
        this.cartItemsQty(this.cart)
        this.calcGrandTotal(this.cart)
        this.dataService.changeCheckoutTotal(this.grandTotal)
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
         this.totalCalculator(this.cart)
         this.cartItemsQty(this.cart)
         this.calcGrandTotal(this.cart)
         this.dataService.changeCheckoutTotal(this.grandTotal)
         return 
    }
  }

  totalCalculator(cart){
    for(let i=0; i<cart.length; i++){
        this.total+=cart[i].subTotal
    }
  }

  calcGrandTotal(cart){
    this.grandTotal = 0
    for(let i=0; i<cart.length; i++){
       this.grandTotal = this.grandTotal + cart[i].subTotal 
    }
  }
  
}
