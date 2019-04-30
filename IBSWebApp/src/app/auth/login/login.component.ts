import { Component, OnInit } from '@angular/core';
import {Customer} from '../../shared/models/customer';
import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import {sha256} from 'js-sha256';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers : [LoginService]
})
export class LoginComponent implements OnInit {

  loggedUser: Customer;

  constructor(private loginService: LoginService, private router: Router,
              private cookieService: CookieService) { }

  ngOnInit() { }

  async getLogin(email: string, password: string) {
    this.loggedUser = await this.loginService.getCustomerDetails(email, password);
    console.log(this.loggedUser);
    console.log('Token ', sha256(email));

    if (this.loggedUser.AccessToken === sha256(email)) {
      this.cookieService.set('Id', this.loggedUser.CustomerId);
      this.cookieService.set('Name', this.loggedUser.FirstName + ' ' + this.loggedUser.LastName);
      this.cookieService.set('token', this.loggedUser.AccessToken);
      this.router.navigate(['customer-panel']);
    }
  }
}
