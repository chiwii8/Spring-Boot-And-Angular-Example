import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from '../../user';
import { UserService } from '../../user.service';
import { Router } from '@angular/router';
import { BehaviorSubject, tap } from 'rxjs';
import { error } from 'node:console';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user-list.component.html'
})
export class UserListComponent implements OnInit{
  
  /// Con el operador !, indicamos a Typescript que la variable se va ha inicializar después
  /// Esto nos sirve para evitar el error de no inicializarla en su declaración o en el constructor.
  /// Pero supone un problema si el método en el que se inicializa no se ejecuta correctamente causando un error.
  ///users!: User[]; 

  ///Otra opción es simplemente inicializarlo en un array vacío siendo lo más sencillo.
  users : User[] = [];

  constructor(private userService: UserService){

  }

  ngOnInit() {
      this.userService.findAll().subscribe({
        next: response => this.users = response,
        error: err => alert('Error:' + err)
      }
        
      );
       
  }

}
