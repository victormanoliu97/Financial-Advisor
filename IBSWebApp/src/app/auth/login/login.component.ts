import { Component, OnInit } from '@angular/core';
import {Customer} from '../../shared/models/customer';
import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';
import { CookieService } from 'ngx-cookie-service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers : [LoginService]
})
export class LoginComponent implements OnInit {

  loggedUser: Customer;

  constructor(private loginService: LoginService, private router: Router, private cookieService: CookieService) { }

  ngOnInit() { }

  async getLogin(email: string, password: string) {
    this.loggedUser = await this.loginService.getCustomerDetails(email, password);
    this.cookieService.set('Id', this.loggedUser.CustomerId);
    console.log(this.loggedUser);
  }
}
