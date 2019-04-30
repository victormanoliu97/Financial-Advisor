import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerBankAccountsService {

  getCustomerBankAccountsUrl = 'http://localhost:4444/customer-bank-accounts';
  deleteCustomerBankAccountUrl = 'http://localhost:4444/delete-bank-account';

  constructor(private http: HttpClient) { }

  async getCustomerBankAccounts(customerId: number): Promise<any> {
   return this.http.get(this.getCustomerBankAccountsUrl + `/${customerId}`).toPromise<any>();
  }

  async deleteCustomerBankAccount(accountId: number): Promise<any> {
    this.http.get(this.deleteCustomerBankAccountUrl + `?AccountId=${accountId}`);
  }
}
