import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UpdateCustomerIncomeRequest} from '../shared/models/requests/income/update-customer-income-request';
import {map} from 'rxjs/operators';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {AddCustomerIncomeRequest} from '../shared/models/requests/income/add-customer-income-request';

@Injectable({
  providedIn: 'root'
})
export class CustomerIncomeService {

  getCustomerIncomesUrl = 'http://localhost:4444//get-customer-incomes/';
  updateCustomerIncomeUrl = 'http://localhost:4444/update-customer-income/';
  deleteCustomerIncomeUrl = 'http://localhost:4444/delete-customer-income/';
  addCustomerIncomeUrl = 'http://localhost:4444/create-customer-income/';

  constructor(private http: HttpClient) {
  }

  async getCustomerIncomes(customerId: number): Promise<any> {
    return this.http.get(this.getCustomerIncomesUrl + `/${customerId}`).toPromise<any>();
  }

  async updateCustomerIncome(incomeAmount: number, incomeSource: string, compressibleCosts: number,
                             nonCompressibleCosts: number, incomeId: number, customerId: number) {
    const request = new UpdateCustomerIncomeRequest();
    request.incomeAmount = incomeAmount;
    request.incomeSource = incomeSource;
    request.compressibleCosts = compressibleCosts;
    request.nonCompressibleCosts = nonCompressibleCosts;
    request.idFinancialIncome = incomeId;
    request.customerId = customerId;

    return this.http.put(this.updateCustomerIncomeUrl + `${incomeId}`, request).pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

  async deleteCustomerIncome(incomeId: number) {
    return this.http.delete(this.deleteCustomerIncomeUrl + `/${incomeId}`).pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

  async addCustomerIncome(incomeAmount: number, incomeSource: string,
                          compressibleCosts: number, nonCompressibleCosts: number, customerId: number) {
    const request = new AddCustomerIncomeRequest();
    request.incomeAmount = incomeAmount;
    request.incomeSource = incomeSource;
    request.compressibleCosts = compressibleCosts;
    request.nonCompressibleCosts = nonCompressibleCosts;
    request.customerId = customerId;

    return this.http.post(this.addCustomerIncomeUrl , request).pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }
}
