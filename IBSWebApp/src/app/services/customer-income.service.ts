import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UpdateCustomerIncomeRequest} from '../shared/models/requests/income/update-customer-income-request';
import {map} from 'rxjs/operators';
import {GenericResponse} from '../shared/models/responses/generic-response';

@Injectable({
  providedIn: 'root'
})
export class CustomerIncomeService {

  getCustomerIncomesUrl = 'http://localhost:4444//get-customer-incomes/';
  updateCustomerIncomeUrl = 'http://localhost:4444/update-customer-income/';

  constructor(private http: HttpClient) { }

  async getCustomerIncomes(customerId: number): Promise<any> {
    return this.http.get(this.getCustomerIncomesUrl + `/${customerId}`).toPromise<any>();
  }

  async updateCustomerIncome(incomeAmount: number, incomeSource: string, compressibleCosts: number, nonCompressibleCosts: number, incomeId: number, customerId: number) {
    const request = new UpdateCustomerIncomeRequest();
    request.incomeAmount = incomeAmount;
    request.incomeSource = incomeSource;
    request.compressibleCosts = compressibleCosts;
    request.nonCompressibleCosts = nonCompressibleCosts;
    request.idFinancialIncome = incomeId;
    request.customerId = customerId;

    console.log('income amount ' + request.incomeAmount);
    console.log('income source' + request.incomeSource);
    console.log('compresible ' + request.compressibleCosts );
    console.log('non', request.nonCompressibleCosts);
    console.log('id' + request.idFinancialIncome);

    return this.http.put(this.updateCustomerIncomeUrl + `${incomeId}`, request).pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }
}
