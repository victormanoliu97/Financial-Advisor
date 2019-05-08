import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerIncomeService {

  getCustomerIncomesUrl = 'http://localhost:4444//get-customer-incomes/';

  constructor(private http: HttpClient) { }

  async getCustomerIncomes(customerId: number): Promise<any> {
    return this.http.get(this.getCustomerIncomesUrl + `/${customerId}`).toPromise<any>();
  }
}
