import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

public showSearch: boolean = true// false;
public cartItems: number =0;

  ngOnInit() {
  }

  displaySearch(){
    this.showSearch = false;
  }

  exitSearch(){
    this.showSearch = true;
  }

  viewCart(){

  }

  login(){
    
  }
}
