import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import {BankAccount} from '../shared/models/bank-account';
import {CustomerBankAccountsService} from '../services/customer-bank-accounts.service';

@Component({
  selector: 'app-customer-panel',
  templateUrl: './customer-panel.component.html',
  styleUrls: ['./customer-panel.component.css']
})
export class CustomerPanelComponent implements OnInit {
  bankAccounts: BankAccount[];
  customerId: number = Number(this.cookieService.get('Id'));
  loggedUserName: string;

  constructor(private cookieService: CookieService, private bankAccountService: CustomerBankAccountsService) { }

  ngOnInit() {
    this.customerId = Number(this.cookieService.get('Id'));
    this.loggedUserName = this.cookieService.get('Name');
    this.bankAccountService.getCustomerBankAccounts(this.customerId).then(bankAccounts => this.bankAccounts = bankAccounts);
  }

}
