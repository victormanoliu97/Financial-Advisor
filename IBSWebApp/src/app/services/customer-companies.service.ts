import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ServerService} from './server.service';
import {map} from 'rxjs/operators';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {AddCustomerCompanyRequest} from '../shared/models/requests/companies/add-customer-company-request';
import {UpdateCustomerCompanyRequest} from '../shared/models/requests/companies/update-customer-company-request';

@Injectable({
  providedIn: 'root'
})
export class CustomerCompaniesService {

  getCustomerCompaniesUrl = 'http://localhost:4444/get-customer-companies';
  addCustomerCompanyUrl = 'http://localhost:4444/create-customer-company';
  deleteCustomerCompanyUrl = 'http://localhost:4444/delete-customer-company';
  updateCustomerCompanyUrl = 'http://localhost:4444/update-customer-company';

  constructor(private http: HttpClient, public serverService: ServerService) { }

  async getCustomerCompanies(customerId: number) {
    return this.http.get(this.getCustomerCompaniesUrl + `/${customerId}`, {headers: this.serverService.requestHeaders} ).toPromise<any>();
  }

  async deleteCustomerCompany(companyId: number) {
    return this.http.delete(this.deleteCustomerCompanyUrl + `/${companyId}`, {headers: this.serverService.requestHeaders}).
    pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

  async addCustomerCompany(companyName: string, companyDescription: string, companyType: string,
                           companyRevenue: number, customerId: number) {
    const request = new AddCustomerCompanyRequest();
    request.companyName = companyName;
    request.companyDescription = companyDescription;
    request.companyType = companyType;
    request.companyRevenue = companyRevenue;
    request.customerId = customerId;

    return this.http.post(this.addCustomerCompanyUrl, request, {headers: this.serverService.requestHeaders}).
    pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

  async updateCustomerCompany(companyName: string, companyDescription: string, companyType: string, companyRevenue: number) {
    const request = new UpdateCustomerCompanyRequest();
    request.companyName = companyName;
    request.companyDescription = companyDescription;
    request.companyType = companyType;
    request.companyRevenue = companyRevenue;

    return this.http.put(this.updateCustomerCompanyUrl, request, {headers: this.serverService.requestHeaders}).
    pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }
}
