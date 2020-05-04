import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/Service/data.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Item } from '../shopping-page/Item';
import { Cart } from '../cart';

@Component({
  selector: 'app-item-search',
  templateUrl: './item-search.component.html',
  styleUrls: ['./item-search.component.css']
})
export class ItemSearchComponent implements OnInit {

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
   total: number = 0;
 
  ngOnInit() {
         this.route.params.subscribe((item) => {this.search = item, this.loadItems(this.search)})
         this.titleCase(this.search.item)
        //  this.dataService.getProductsView().subscribe(response => (this.searchedItems = response.filter
        //  ((item) => item.name.startsWith(this.splitStr)))) 
         
      //  this.dataService.getProductsView().subscribe(response => (this.searchedItems = response));
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
         if(this.cart.length===1){
         this.total+=this.cart[0].subTotal}
             
       console.log("New item is added in the cart!")
       
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
             return 
        }
    }

    totalCalculator(cart){
      for(let i=0; i<cart.length; i++){
          this.total+=cart[i].subTotal
      }
    }
    
 }

