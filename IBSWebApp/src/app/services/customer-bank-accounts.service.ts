import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {ServerService} from './server.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerBankAccountsService {

  getCustomerBankAccountsUrl = 'http://localhost:4444/customer-bank-accounts';
  deleteCustomerBankAccountUrl = 'http://localhost:4444/delete-bank-account';

  constructor(private http: HttpClient, public serverService: ServerService) { }

  async getCustomerBankAccounts(customerId: number): Promise<any> {
   return this.http.get(this.getCustomerBankAccountsUrl + `/${customerId}`).toPromise<any>();
  }

  async deleteCustomerBankAccount(accountId: number): Promise<any> {
    return this.http.delete(this.deleteCustomerBankAccountUrl + `/${accountId}`, {headers: this.serverService.requestHeaders}).
    pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }
}
