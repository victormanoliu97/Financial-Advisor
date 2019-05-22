import { Component, OnInit } from '@angular/core';
import {CustomerIncome} from '../shared/models/income/customer-income';
import {CookieService} from 'ngx-cookie-service';
import {CustomerIncomeService} from '../services/customer-income.service';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {MessageConstants} from '../shared/models/constant/message-constants';
import {SectionCompletion} from '../shared/models/completion/section-completion';

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

  updateIncomeRequestResponse: GenericResponse;
  requestResponseMessage: string;


  constructor(private cookieService: CookieService, private incomeService: CustomerIncomeService) { }

  ngOnInit() {
    this.customerId = Number(this.cookieService.get('Id'));
    this.loggedUserName = this.cookieService.get('Name');
    this.incomeService.getCustomerIncomes(this.customerId).then(incomes => this.incomes = incomes);
    this.updateIncomeRequestResponse = new GenericResponse();
    this.updateIncomeRequestResponse.responseCode = 0;
  }

  checkFieldsValid() {
    return !(this.incomeSource == null || this.incomeAmount == null);
  }

  async updateIncome(incomeId: number) {
    if (this.checkFieldsValid() === true) {
      this.updateIncomeRequestResponse = await this.incomeService.updateCustomerIncome(this.incomeAmount, this.incomeSource,
        this.compressibleCosts, this.nonCompressibleCosts, incomeId, this.customerId);
    } else {
      this.updateIncomeRequestResponse.responseCode = 422;
      this.requestResponseMessage = MessageConstants.INCOME_MISSING_FIELDS;
    }

    if (this.updateIncomeRequestResponse.responseCode === 200) {
      this.requestResponseMessage = MessageConstants.INCOME_UPDATE_SUCCESSFUL;
    }  else if (this.updateIncomeRequestResponse.responseCode !== 422) {
      this.requestResponseMessage = MessageConstants.WEBSERVICE_ERROR + ' ' + this.updateIncomeRequestResponse.responseMessage;
    }
  }

}
