import { Component, OnInit } from '@angular/core';
import {GenericResponse} from '../../shared/models/responses/generic-response';
import {Router} from '@angular/router';
import {RegisterService} from '../../services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  firstName: string;
  lastName: string;
  cnp: string;
  age: number;
  email: string;
  password: string;

  registerRequestResponse: GenericResponse;

  constructor(private registerService: RegisterService, private router: Router) { }

  private checkValidFields() {
    return !(this.firstName == null || this.lastName == null || this.cnp == null || this.age == null
      || this.email == null || this.password == null);
  }

  ngOnInit() {
    this.registerRequestResponse = new GenericResponse();
    this.registerRequestResponse.responseCode = 0;
  }

  async register() {
    if (this.checkValidFields() === true) {
      this.registerRequestResponse = await this.registerService.register(this.firstName, this.lastName,
        this.cnp, this.age, this.email, this.password);
    }
    console.log(this.registerRequestResponse);
    if (this.registerRequestResponse.responseCode === 200) {
      this.router.navigate(['login']);
    }
  }

}
