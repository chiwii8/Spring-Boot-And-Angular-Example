import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './core/user/component/user-list/user-list.component';
import { UserFormComponent } from './core/user/component/user-form/user-form.component';
import { NgModule } from '@angular/core';
import { LoginFormComponent } from './core/auth/component/login-form/login-form.component';

export const routes: Routes = [
    {path: 'users', component: UserListComponent},
    {path: 'adduser', component: UserFormComponent},
    {path:'login', component: LoginFormComponent},
    {path: '', redirectTo:'/users', pathMatch:'full'}
];


export class AppRoutingModule{}
