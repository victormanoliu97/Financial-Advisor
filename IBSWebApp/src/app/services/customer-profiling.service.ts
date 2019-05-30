import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ServerService} from './server.service';
import {UpdateCustomerProfilingRequest} from '../shared/models/requests/profiling/update-customer-profiling-request';
import {map} from 'rxjs/operators';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {AddCustomerProfilingRequest} from '../shared/models/requests/profiling/add-customer-profiling-request';

@Injectable({
  providedIn: 'root'
})
export class CustomerProfilingService {

  getCustomerProfilingUrl = 'http://localhost:4444/get-profiling/';
  updateCustomerProfilingUrl = 'http://localhost:4444/update-profiling/';
  addCustomerProfilingUrl = 'http://localhost:4444/save-profiling/';

  constructor(private http: HttpClient, public serverService: ServerService) {
  }

  async getCustomerProfiling(customerId: number) {
    return this.http.get(this.getCustomerProfilingUrl + `${customerId}`, {headers: this.serverService.requestHeaders}).toPromise<any>();
  }

  async addCustomerProfiling(idCustomer: number, profession: string,
                             residenceCity: string, residenceProvince: string, workSegment: string,
                             currentJob: string, birthCity: string, birthResidence: string, gender: string) {
    const request = new AddCustomerProfilingRequest();
    request.idCustomer = idCustomer;
    request.profession = profession;
    request.residenceCity = residenceCity;
    request.residenceProvince = residenceProvince;
    request.workSegment = workSegment;
    request.currentJob = currentJob;
    request.birthCity = birthCity;
    request.birthResidence = birthResidence;
    request.gender = gender;

    console.log('Birth City ' + birthCity);

    return this.http.post(this.addCustomerProfilingUrl, request,
      {headers: this.serverService.requestHeaders}).pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }

  async updateCustomerProfiling(idProfiling: number, idCustomer: number, profession: string,
                                residenceCity: string, residenceProvince: string, workSegment: string,
                                currentJob: string, birthCity: string, birthResidence: string, gender: string) {
    const request = new UpdateCustomerProfilingRequest();
    request.idProfiling = idProfiling;
    request.idCustomer = idCustomer;
    request.profession = profession;
    request.residenceCity = residenceCity;
    request.residenceProvince = residenceProvince;
    request.workSegment = workSegment;
    request.currentJob = currentJob;
    request.birthCity = birthCity;
    request.birthResidence = birthResidence;
    request.gender = gender;

    console.log('Id Prof ' + idProfiling);

    return this.http.put(this.updateCustomerProfilingUrl + `${idProfiling}`, request,
      {headers: this.serverService.requestHeaders}).pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }
}
