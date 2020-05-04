import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap, mapTo, catchError } from 'rxjs/operators';
import { of } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  private user: ExistingUser  = new ExistingUser();

public token: Token;

  authenticateUser(email, password){
    this.user.email = email;
    this.user.password = password
 
    return this.httpClient.post<Token>('http://localhost:8080/api/auth/signin',
    this.user)
  }
 
  isLoggedIn(){
    return localStorage.getItem('access_token') !==  null;
  }

  getUserEmail(){
    return sessionStorage.getItem("AuthenticatedUser")
  }

  logoutService(){
    localStorage.removeItem('access_token');
  }
}

export class ExistingUser{
   email: string;
   password: string
}

export class Token{
  accessToken: string;
  accessType: string
}