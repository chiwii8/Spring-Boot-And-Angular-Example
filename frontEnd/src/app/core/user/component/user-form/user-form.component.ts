import { Component } from '@angular/core';
import { User } from '../../user';
import { HttpClient } from '@angular/common/http';
import { Router, RouterOutlet } from '@angular/router';
import { UserService } from '../../user.service';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-user-form',
  imports: [CommonModule,FormsModule],
  templateUrl: './user-form.component.html',
  styleUrl: './user-form.component.css'
})

export class UserFormComponent {
    user: User;

    constructor(private http:HttpClient,private router: Router, private userService: UserService){
      this.user = new User();
    }


    gotUserList(){
      this.router.navigate(['/users'])
    }

    onSubmit(){
      this.userService.save(this.user).subscribe(
        result => this.gotUserList(),
        error => console.error('Error al enviar los datos',error))
    }
}
