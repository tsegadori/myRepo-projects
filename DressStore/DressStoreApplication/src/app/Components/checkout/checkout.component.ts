import { Component, OnInit, NgZone, ViewChild, ElementRef, AfterViewInit, OnDestroy } from '@angular/core';
import { DataService } from 'src/app/Service/data.service';
import { Cart } from '../cart';
import { HttpHeaders } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Http, RequestOptions } from '@angular/http';
import { assertDataInRangeInternal } from '@angular/core/src/render3/util';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor(private http:Http, private dataService: DataService, private router: Router,
    private _ngZone: NgZone) { }

  public grandTotal: number;
  public cart: Cart[] = [];
  cardNumber: number;
  expMonth: number;
  expYear: number;
  cvc: number;
  responsemessage: string;

  ngOnInit() {
    // this.cart = this.dataService.cart
     this.grandTotal = this.dataService.grandTotal
  }

  message: string = '';

  chargeCreditCard() {
    this.message = 'Loading...';

    (<any>window).Stripe.card.createToken({
      number: this.cardNumber,
      exp_month: this.expMonth,
      exp_year: this.expYear,
      cvc: this.cvc
    }, (status: number, response: any) => {
      if (status === 200) {
        let token = response.id;
        this.chargeCard(token);
        console.log('Success! Card token '+response.card.id)
        this.responsemessage = "Success! Payment processed successfuly! Thank you for shopping with us."
        this.setMessage(this.responsemessage) 
        console.log("###### "+this.responsemessage)
        this._ngZone.run(() => { this.router.navigate(['/payment'])});
        }
       if(!(status === 200)) {
        this.message = response.error.message;
        this.responsemessage = "Error! Credit card couldn't processed successfuly. Please try again."
        this.setMessage(this.responsemessage) 
        console.log(this.responsemessage)
        this._ngZone.run(() => { this.router.navigate(['/payment-error'])});
        }
       });  


  }

  setMessage(message){
    this.responsemessage = message
  }
  getMessage(){
    return this.responsemessage
  }

  chargeCard(token: string) {
   
    let paymentInfo: PaymentInfo = new PaymentInfo()
    paymentInfo.token = token
    paymentInfo.amount = this.grandTotal

    this.http.post('http://localhost:8080/payment/charge', paymentInfo).subscribe(resp => {
       console.log(resp);
       })
  }

 }

 export class  PaymentInfo{
   token: string;
   amount: number;
 }