import { Component, OnInit } from '@angular/core';
import {BankAccount} from '../shared/models/bank-account';
import {CustomerIncome} from '../shared/models/customer-income';
import {CookieService} from 'ngx-cookie-service';
import {CustomerIncomeService} from '../services/customer-income.service';

@Component({
  selector: 'app-income-liabilities',
  templateUrl: './income-liabilities.component.html',
  styleUrls: ['./income-liabilities.component.css']
})
export class IncomeLiabilitiesComponent implements OnInit {
  incomes: CustomerIncome[];
  customerId: number = Number(this.cookieService.get('Id'));
  loggedUserName: string;

  constructor(private cookieService: CookieService, private incomeService: CustomerIncomeService) { }

  ngOnInit() {
    this.customerId = Number(this.cookieService.get('Id'));
    this.loggedUserName = this.cookieService.get('Name');
    this.incomeService.getCustomerIncomes(this.customerId).then(incomes => this.incomes = incomes);
  }

}
