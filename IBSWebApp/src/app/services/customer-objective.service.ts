import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ServerService} from './server.service';
import {map} from 'rxjs/operators';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {AddCustomerObjectiveRequest} from '../shared/models/requests/objective/add-customer-objective-request';

@Injectable({
  providedIn: 'root'
})
export class CustomerObjectiveService {

  addCustomerObjectiveUrl = 'http://localhost:4444/create-customer-objective/';
  getCustomerObjectivesUrl = 'http://localhost:4444/get-customer-objectives/';
  deleteCustomerObjectiveUrl = 'http://localhost:4444/delete-customer-objective';

  constructor(private http: HttpClient, public serverService: ServerService) { }

  async getCustomerObjectives(customerId: number): Promise<any> {
    return this.http.get(this.getCustomerObjectivesUrl + `/${customerId}`, {headers: this.serverService.requestHeaders}).toPromise<any>();
  }

  async deleteCustomerObjective(id: number) {
    return this.http.delete(this.deleteCustomerObjectiveUrl + `/${id}`, {headers: this.serverService.requestHeaders})
      .pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

  async addCustomerObjective(customerId: number, objectiveValue: number, objectiveName: string, years: number) {
    const request = new AddCustomerObjectiveRequest();
    request.customerId = customerId;
    request.objectiveValue = objectiveValue;
    request.income = 0;
    request.objectiveName = objectiveName;
    request.years = years;

    return this.http.post(this.addCustomerObjectiveUrl , request, {headers: this.serverService.requestHeaders})
      .pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }
}
