import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ServerService} from './server.service';
import {map} from 'rxjs/operators';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {AddCustomerEstateRequest} from '../shared/models/requests/estates/add-customer-estate-request';
import {UpdateCustomerEstateRequest} from '../shared/models/requests/estates/update-customer-estate-request';

@Injectable({
  providedIn: 'root'
})
export class CustomerEstatesService {

  getCustomerEstatesUrl = 'http://localhost:4444/get-customer-estates/';
  addCustomerEstateUrl = 'http://localhost:4444/save-customer-estate/';
  deleteCustomerEstateUrl = 'http://localhost:4444/delete-customer-estate/';
  updateCustomerEstateUrl = 'http://localhost:4444/update-customer-estate/';

  constructor(private http: HttpClient, public serverService: ServerService) { }

  async getCustomerEstates(customerId: number): Promise<any> {
    return this.http.get(this.getCustomerEstatesUrl + `${customerId}`, {headers: this.serverService.requestHeaders} ).toPromise<any>();
  }

  async deleteCustomerEstate(estateId: number) {
    return this.http.delete(this.deleteCustomerEstateUrl + `${estateId}`, {headers: this.serverService.requestHeaders}).
    pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

  async addCustomerEstate(estateName: string, estateDescription: string, estateType: string, estateValue: number, customerId: number) {
    const request = new AddCustomerEstateRequest();
    request.estateName = estateName;
    request.estateDescription = estateDescription;
    request.estateType = estateType;
    request.estateValue = estateValue;
    request.customerId = customerId;

    return this.http.post(this.addCustomerEstateUrl, request, {headers: this.serverService.requestHeaders}).
    pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

  async updateCustomerEstate(estateId: number, estateName: string, estateDescription: string, estateType: string, estateValue: number, customerId: number) {
    const request = new UpdateCustomerEstateRequest();
    request.estateId = estateId;
    request.estateName = estateName;
    request.estateDescription = estateDescription;
    request.estateType = estateType;
    request.estateValue = estateValue;
    request.customerId = customerId;

    console.log('Request ' + request.estateId);
    console.log('Param ' + estateId);

    return this.http.put(this.updateCustomerEstateUrl + `${estateId}`, request, {headers: this.serverService.requestHeaders}).
    pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }
}
