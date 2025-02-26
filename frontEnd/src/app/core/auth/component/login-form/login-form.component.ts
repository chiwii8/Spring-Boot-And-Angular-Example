import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AuthService } from '../../auth.service';
import { Router, RouterLink } from '@angular/router';
import { Credentials } from '../../auth';
import { FormsModule, NgModel } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login-form',
  imports: [RouterLink,CommonModule,FormsModule],
  templateUrl: './login-form.component.html'
})
export class LoginFormComponent {

  credentials : Credentials;

  constructor(private Http:HttpClient, private router: Router,private authService: AuthService){
    this.credentials = new Credentials();
  }

  private sucessLogin(){
    this.router.navigate(['/users']);
  }

  onSubmit(){
    this.authService.login(this.credentials).subscribe({
      next: response => {
        console.log('token recibido' + response.token)
        localStorage.setItem('access_token',response.token)
        this.sucessLogin();
      },
      error: err => {alert('Failed login:' + err)
        console.error('Error',err.message);}
      }
    )
  }
  
}
