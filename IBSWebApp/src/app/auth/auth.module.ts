import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginComponent} from './login/login.component';
import { FormsModule } from '@angular/forms';
import {ToastModule} from 'primeng/toast';
import { RegisterComponent } from './register/register.component';

@NgModule({
  declarations: [LoginComponent, RegisterComponent],
  imports: [
    CommonModule,
    FormsModule,
    ToastModule
  ],
  exports : [
    LoginComponent
  ]
})
export class AuthModule { }
