import { Component, OnInit } from '@angular/core';
import {BankAccount} from '../shared/models/bank-account';
import {CustomerBankAccountsService} from '../services/customer-bank-accounts.service';
import {CookieService} from 'ngx-cookie-service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-bank-accounts',
  templateUrl: './customer-bank-accounts.component.html',
  styleUrls: ['./customer-bank-accounts.component.css']
})
export class CustomerBankAccountsComponent implements OnInit {

  bankAccounts: BankAccount[];
  customerId: number = Number(this.cookieService.get('Id'));
  selectedAccount: BankAccount;
  loggedUserName: string;

  constructor(private bankAccountService: CustomerBankAccountsService, private cookieService: CookieService, private router: Router) { }

  ngOnInit() {
    this.customerId = Number(this.cookieService.get('Id'));
    this.loggedUserName = this.cookieService.get('Name');
    if (this.cookieService.get('token') != null) {
      this.bankAccountService.getCustomerBankAccounts(this.customerId).then(bankAccounts => this.bankAccounts = bankAccounts);
    }
  }

  onSelect(account: BankAccount) {
    this.selectedAccount = account;
    this.router.navigate(['account-details']);
  }

  returnSelectedAccount() {
    return this.selectedAccount;
  }

}
