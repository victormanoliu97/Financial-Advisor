import {AfterViewInit, Component, OnInit} from '@angular/core';
import {CustomerBankAccountsComponent} from '../customer-bank-accounts/customer-bank-accounts.component';
import {BankAccount} from '../shared/models/bank-account';

@Component({
  selector: 'app-bank-account-details',
  templateUrl: './bank-account-details.component.html',
  styleUrls: ['./bank-account-details.component.css']
})
export class BankAccountDetailsComponent implements AfterViewInit {

  selectedAccount: BankAccount = this.customerBankAccountComp.returnSelectedAccount();

  constructor(private customerBankAccountComp: CustomerBankAccountsComponent) { }

  ngAfterViewInit(): void {
  }

}
