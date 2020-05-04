import { Component, OnInit, Input } from '@angular/core';
import { AuthenticationService, Token } from 'src/app/Service/authentication.service';
import { Router } from '@angular/router';
import { User } from 'src/app/User';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  constructor(private authenticate: AuthenticationService, private router: Router) { }

  private user: User = new User();

  ngOnInit() {
  }

  @Input() public login;
  @Input() public signInOrUp;
  public token: Token = new Token();
  public error: string;

  onSubmit(user){
    
    this.authenticate.authenticateUser(user.email, user.password).subscribe(
      accesstoken => {this.token.accessToken = accesstoken.accessToken,
         localStorage.setItem('access_token', this.token.accessToken), 
         console.log("User is logged in "+user.email),
          this.router.navigateByUrl('/')}, err => this.error = 'Could not authenticate');
          return true;}
   }

