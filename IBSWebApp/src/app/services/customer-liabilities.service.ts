import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {ServerService} from './server.service';
import {map} from 'rxjs/operators';
import {UpdateCustomerLiabilityRequest} from '../shared/models/requests/liability/update-customer-liability-request';
import {AddCustomerLiabilityRequest} from '../shared/models/requests/liability/add-customer-liability-request';

@Injectable({
  providedIn: 'root'
})
export class CustomerLiabilitiesService {

  addCustomerLiabilitiesUrl = 'http://localhost:4444/create-customer-liability';
  getCustomerLiabilitiesUrl = 'http://localhost:4444/get-customer-liabilities/';
  updateCustomerLiabilityUrl = 'http://localhost:4444/update-customer-liability';
  deleteCustomerLiabilityUrl = 'http://localhost:4444/delete-customer-liability';

  constructor(private http: HttpClient, public serverService: ServerService) {
  }

  async getCustomerLiabilities(customerId: number): Promise<any> {
    return this.http.get(this.getCustomerLiabilitiesUrl + `/${customerId}`, {headers: this.serverService.requestHeaders}).toPromise<any>();
  }

  async updateCustomerLiability(idFinancialLiability: number, liabilitiesAmount: number, liabilitiesSource: string, customerId: number) {
    const request = new UpdateCustomerLiabilityRequest();
    request.idFinancialLiability = idFinancialLiability;
    request.liabilitiesAmount = liabilitiesAmount;
    request.liabilitiesSource = liabilitiesSource;
    request.customerId = customerId;

    return this.http.put(this.updateCustomerLiabilityUrl + `/${idFinancialLiability}`, request,
      {headers: this.serverService.requestHeaders}).pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

  async deleteCustomerLiability(liabilityId: number) {
    return this.http.delete(this.deleteCustomerLiabilityUrl + `/${liabilityId}`,
      {headers: this.serverService.requestHeaders}).pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

  async addCustomerLiability(liabilitiesAmount: number, liabilitiesSource: string, customerId: number) {
    const request = new AddCustomerLiabilityRequest();
    request.liabilitiesAmount = liabilitiesAmount;
    request.liabilitiesSource = liabilitiesSource;
    request.customerId = customerId;

    return this.http.post(this.addCustomerLiabilitiesUrl, request,
      {headers: this.serverService.requestHeaders}).pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

}
