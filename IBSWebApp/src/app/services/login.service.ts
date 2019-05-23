import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../shared/models/customer/customer';
import { map } from 'rxjs/operators';
import {ServerService} from './server.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loginUrl = 'http://localhost:5000/Login';

  constructor(private http: HttpClient, public serverService: ServerService) { }

  async getCustomerDetails(login: string, pass: string): Promise<Customer> {
    const body = {email: login, password: pass};
    return this.http.post(this.loginUrl, body, {headers: this.serverService.requestHeaders}).pipe(map((result: Customer) => {
      return result;
    })).toPromise();
  }
}
