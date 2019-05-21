import { Component, OnInit } from '@angular/core';
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

  incomeAmount: number;
  incomeSource: string;
  compressibleCosts: number;
  nonCompressibleCosts: number;

  constructor(private cookieService: CookieService, private incomeService: CustomerIncomeService) { }

  ngOnInit() {
    this.customerId = Number(this.cookieService.get('Id'));
    this.loggedUserName = this.cookieService.get('Name');
    this.incomeService.getCustomerIncomes(this.customerId).then(incomes => this.incomes = incomes);
  }

  async updateIncome(incomeId: number) {
    const response = await this.incomeService.updateCustomerIncome(this.incomeAmount, this.incomeSource,
      this.compressibleCosts, this.nonCompressibleCosts, incomeId, this.customerId);
  }

}
