import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Credentials } from './auth';
import { UserService } from '../user/user.service';

@Injectable({
  providedIn: 'root'
})



export class AuthService {

  private AuthUrl: string

  constructor( private http: HttpClient, private userService: UserService){
    this.AuthUrl= 'http://localhost:8080/token';
  }

  public login(credentials :Credentials){
    const authCred = btoa(credentials.username + ':' + credentials.password)
    const headers = new HttpHeaders({'Authorization': `Basic ${authCred}`});

   return this.http.post<{token:string }>(this.AuthUrl,{},{ headers });

  }

  public logout(){
    localStorage.removeItem('access_token');
  }

}