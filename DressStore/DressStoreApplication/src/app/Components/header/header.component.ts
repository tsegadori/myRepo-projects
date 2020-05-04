import { Component, OnInit, OnChanges } from '@angular/core';
import { DataService } from 'src/app/Service/data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit{
  
  constructor(private dataService: DataService, private route: Router) { }
  
  searchedItems: Item[];
  searchQuery: string = '';
  cartItems: any;

   ngOnInit() {
    this.dataService.currentMessage.subscribe(message => 
      {this.cartItems = message})

   }

   itemsQty(items){
     this.cartItems = items
   }

  saveSearch(){
          this.route.navigate(['search-items', this.searchQuery])
    }

    logout(){
      sessionStorage.removeItem('AuthenticatedUser')
    }
}

export class Item{
  id: number;
  name: string;
  price: number;
  imgSrc: string;
}
