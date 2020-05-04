import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/Service/authentication.service';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {

  constructor(private authentication: AuthenticationService) { }

  public AuthenticatedUser: boolean;

  ngOnInit() {
    this.AuthenticatedUser = this.authentication.isLoggedIn()
  }

}
