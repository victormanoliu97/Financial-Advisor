import { Component, OnInit } from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {Router} from '@angular/router';
import {CustomerIncomeService} from '../services/customer-income.service';
import {CustomerEstatesService} from '../services/customer-estates.service';
import {CustomerCompaniesService} from '../services/customer-companies.service';
import {CustomerProfilingService} from '../services/customer-profiling.service';
import {FinancialInstrumentsService} from '../services/financial-instruments.service';
import {CustomerIncome} from '../shared/models/income/customer-income';
import {CustomerEstate} from '../shared/models/estate/customer-estate';
import {CustomerCompanies} from '../shared/models/companies/customer-companies';
import {CustomerProfiling} from '../shared/models/profiling/customer-profiling';
import {Stock} from '../shared/models/financial_instruments/stock';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.css']
})
export class StocksComponent implements OnInit {

  incomes: CustomerIncome[];
  estates: CustomerEstate[];
  companies: CustomerCompanies[];
  profiling: CustomerProfiling[];
  stocks: Stock[];
  customerId: number = Number(this.cookieService.get('Id'));
  loggedUserName: string;

  constructor(private cookieService: CookieService, public financialInstrumentsService: FinancialInstrumentsService,
              private router: Router, public incomeService: CustomerIncomeService,
              public estateService: CustomerEstatesService,
              public companyService: CustomerCompaniesService,
              public profilingService: CustomerProfilingService) { }

  ngOnInit() {
    if (this.cookieService.get('Id') === '') {
      this.router.navigate(['login']);
    } else {
      this.customerId = Number(this.cookieService.get('Id'));
      this.loggedUserName = this.cookieService.get('Name');
      this.incomeService.getCustomerIncomes(this.customerId).then(incomes => this.incomes = incomes);
      this.estateService.getCustomerEstates(this.customerId).then(estates => this.estates = estates);
      this.companyService.getCustomerCompanies(this.customerId).then(companies => this.companies = companies);
      this.profilingService.getCustomerProfiling(this.customerId).then(profiling => this.profiling = profiling);
      this.financialInstrumentsService.getStocks().then(stocks => this.stocks = stocks);
    }
  }

  logout() {
    this.cookieService.delete('Id');
    this.cookieService.delete('Name');
    this.cookieService.delete('token');
    this.router.navigate(['login']);
  }

  reloadData() {
    window.location.reload();
  }
}
