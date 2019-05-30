import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import {BankAccount} from '../shared/models/account/bank-account';
import {CustomerBankAccountsService} from '../services/customer-bank-accounts.service';
import {Router} from '@angular/router';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {CustomerIncome} from '../shared/models/income/customer-income';
import {CustomerIncomeService} from '../services/customer-income.service';
import {CustomerEstate} from '../shared/models/estate/customer-estate';
import {CustomerEstatesService} from '../services/customer-estates.service';
import {CustomerCompaniesService} from '../services/customer-companies.service';
import {CustomerCompanies} from '../shared/models/companies/customer-companies';
import {CustomerProfilingService} from '../services/customer-profiling.service';
import {CustomerProfiling} from '../shared/models/profiling/customer-profiling';

@Component({
  selector: 'app-customer-panel',
  templateUrl: './customer-panel.component.html',
  styleUrls: ['./customer-panel.component.css']
})
export class CustomerPanelComponent implements OnInit {
  bankAccounts: BankAccount[];
  incomes: CustomerIncome[];
  estates: CustomerEstate[];
  companies: CustomerCompanies[];
  profiling: CustomerProfiling[];
  deleteBankAccountRequestResponse: GenericResponse;
  customerId: number = Number(this.cookieService.get('Id'));
  loggedUserName: string;

  constructor(private cookieService: CookieService, private bankAccountService: CustomerBankAccountsService,
              private router: Router, public incomeService: CustomerIncomeService,
              public estateService: CustomerEstatesService,
              public companyService: CustomerCompaniesService,
              public profilingService: CustomerProfilingService) { }

  ngOnInit() {
    if (this.cookieService.get('Id') === '') {
      this.router.navigate(['login']);
    } else {
      this.deleteBankAccountRequestResponse = new GenericResponse();
      this.deleteBankAccountRequestResponse.responseCode = 0;
      this.customerId = Number(this.cookieService.get('Id'));
      this.loggedUserName = this.cookieService.get('Name');
      this.bankAccountService.getCustomerBankAccounts(this.customerId).then(bankAccounts => this.bankAccounts = bankAccounts);
      this.incomeService.getCustomerIncomes(this.customerId).then(incomes => this.incomes = incomes);
      this.estateService.getCustomerEstates(this.customerId).then(estates => this.estates = estates);
      this.companyService.getCustomerCompanies(this.customerId).then(companies => this.companies = companies);
      this.profilingService.getCustomerProfiling(this.customerId).then(profiling => this.profiling = profiling);
    }
  }

  async deleteBankAccount(accountId: number) {
    this.deleteBankAccountRequestResponse = await this.bankAccountService.deleteCustomerBankAccount(accountId);
    if (this.deleteBankAccountRequestResponse.responseCode === 200) {
      window.location.reload();
    }
  }

}
