import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/Service/data.service';
import { Cart } from '../cart';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor(private dataService: DataService) { }

  public grandTotal: number;
  public cart: Cart[] = [];
  
  ngOnInit() {
    this.cart = this.dataService.cart
    this.grandTotal = this.dataService.grandTotal
  }

}
