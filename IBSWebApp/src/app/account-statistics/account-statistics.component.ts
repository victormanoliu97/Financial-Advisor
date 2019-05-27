import { Component, OnInit } from '@angular/core';
import {CustomerIncomeService} from '../services/customer-income.service';
import {CustomerLiabilitiesService} from '../services/customer-liabilities.service';
import {CustomerIncome} from '../shared/models/income/customer-income';
import {CustomerLiability} from '../shared/models/liabilities/customer-liability';
import {CookieService} from 'ngx-cookie-service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-account-statistics',
  templateUrl: './account-statistics.component.html',
  styleUrls: ['./account-statistics.component.css']
})
export class AccountStatisticsComponent implements OnInit {

  incomeData: any;
  labels: string[] = [];
  effectiveData: number[] = [];

  incomes: CustomerIncome[];
  liabilities: CustomerLiability[];
  customerId: number = Number(this.cookieService.get('Id'));
  loggedUserName: string;

  constructor(private cookieService: CookieService, public incomeService: CustomerIncomeService,
              public liabilityService: CustomerLiabilitiesService, private router: Router) {
    this.incomeData = {
      labels: this.labels,
      datasets: [
        {
          data: this.effectiveData,
          backgroundColor: [
            '#FF6384',
            '#36A2EB',
            '#FFCE56'
          ],
          hoverBackgroundColor: [
            '#FF6384',
            '#36A2EB',
            '#FFCE56'
          ]
        }]
    };
  }

  async ngOnInit() {
    if (this.cookieService.get('Id') === '') {
      this.router.navigate(['login']);
    } else {
      this.customerId = Number(this.cookieService.get('Id'));
      this.loggedUserName = this.cookieService.get('Name');
      this.incomes = await this.incomeService.getCustomerIncomes(this.customerId);
      this.liabilities = await this.liabilityService.getCustomerLiabilities(this.customerId);

      this.incomes.forEach((element) => {
        this.labels.push(element.incomeSource);
      });

      this.incomes.forEach((element) => {
        this.effectiveData.push(element.incomeAmount);
      });
    }
  }

}
