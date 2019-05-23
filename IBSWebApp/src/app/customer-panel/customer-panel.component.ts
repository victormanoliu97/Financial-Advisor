import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import {BankAccount} from '../shared/models/account/bank-account';
import {CustomerBankAccountsService} from '../services/customer-bank-accounts.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-panel',
  templateUrl: './customer-panel.component.html',
  styleUrls: ['./customer-panel.component.css']
})
export class CustomerPanelComponent implements OnInit {
  bankAccounts: BankAccount[];
  customerId: number = Number(this.cookieService.get('Id'));
  loggedUserName: string;

  constructor(private cookieService: CookieService, private bankAccountService: CustomerBankAccountsService, private router: Router) { }

  ngOnInit() {
    if (this.cookieService.get('Id') === '') {
      this.router.navigate(['login']);
    } else {
      this.customerId = Number(this.cookieService.get('Id'));
      this.loggedUserName = this.cookieService.get('Name');
      this.bankAccountService.getCustomerBankAccounts(this.customerId).then(bankAccounts => this.bankAccounts = bankAccounts);
    }
  }

}
