import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ServerService} from './server.service';
import {RegisterRequest} from '../shared/models/requests/auth/register-request';
import {map} from 'rxjs/operators';
import {GenericResponse} from '../shared/models/responses/generic-response';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  registerUrl = 'http://localhost:5000/Register/';

  constructor(private http: HttpClient, public serverService: ServerService) { }

  async register(firstName: string, lastName: string, cnp: string,
                 age: number,
                 email: string, password: string) {
    const request = new RegisterRequest();
    request.firstName = firstName;
    request.lastName = lastName;
    request.cnp = cnp;
    request.age = age;
    request.email = email;
    request.password = password;

    return this.http.post(this.registerUrl, request,
      {headers: this.serverService.requestHeaders}).pipe(map((result: GenericResponse) => {
      return result;
    })).toPromise();
  }
}
