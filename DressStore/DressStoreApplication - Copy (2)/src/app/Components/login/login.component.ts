import { Component, OnInit} from '@angular/core';
import { DataService } from 'src/app/Service/data.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private data: DataService) { }

  ngOnInit() {
  }

  basicAuthenticate(data: NgForm){
   let username = data.value.email
   let password = data.value.pwd
   console.log(username)
    this.data.basicAuthentication(username, password)
  }

}
