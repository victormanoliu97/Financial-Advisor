import { Component, OnInit } from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {Router} from '@angular/router';
import {CustomerIncomeService} from '../services/customer-income.service';
import {CustomerEstatesService} from '../services/customer-estates.service';
import {CustomerCompaniesService} from '../services/customer-companies.service';
import {CustomerIncome} from '../shared/models/income/customer-income';
import {CustomerEstate} from '../shared/models/estate/customer-estate';
import {CustomerCompanies} from '../shared/models/companies/customer-companies';
import {CustomerProfiling} from '../shared/models/profiling/customer-profiling';
import {CustomerProfilingService} from '../services/customer-profiling.service';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {MessageConstants} from '../shared/models/constant/message-constants';

@Component({
  selector: 'app-customer-profiling',
  templateUrl: './customer-profiling.component.html',
  styleUrls: ['./customer-profiling.component.css']
})
export class CustomerProfilingComponent implements OnInit {

  customerId: number = Number(this.cookieService.get('Id'));
  loggedUserName: string;
  incomes: CustomerIncome[];
  estates: CustomerEstate[];
  companies: CustomerCompanies[];
  profiling: CustomerProfiling[];
  updateProfilingRequestResponse: GenericResponse;

  currentProfiling: CustomerProfiling;

  profession: string;
  residenceCity: string;
  residenceProvince: string;
  workSegment: string;
  currentJob: string;
  birthCity: string;
  birthResidence: string;
  gender: string;

  requestResponseMessage: String;

  constructor(private cookieService: CookieService, private router: Router, public incomeService: CustomerIncomeService,
              public estateService: CustomerEstatesService, public companyService: CustomerCompaniesService,
              public profilingService: CustomerProfilingService) { }

   private checkProfilingFieldsValid() {
    return !(this.currentProfiling.profession == null || this.currentProfiling.residenceCity == null ||
      this.currentProfiling.workSegment == null || this.currentProfiling.currentJob == null ||
      this.currentProfiling.birthCity == null || this.currentProfiling.birthResidence == null || this.currentProfiling.gender == null);
   }

   private checkProfilingAddFields() {
     return !(this.profession == null || this.residenceCity == null ||
       this.workSegment == null || this.currentJob == null ||
       this.birthCity == null || this.birthResidence == null || this.gender == null);
   }

  ngOnInit() {
    if (this.cookieService.get('Id') === '') {
      this.router.navigate(['login']);
    } else {
      this.customerId = Number(this.cookieService.get('Id'));
      this.loggedUserName = this.cookieService.get('Name');
      this.incomeService.getCustomerIncomes(this.customerId).then(incomes => this.incomes = incomes);
      this.estateService.getCustomerEstates(this.customerId).then(estates => this.estates = estates);
      this.companyService.getCustomerCompanies(this.customerId).then(companies => this.companies = companies);
      this.profilingService.getCustomerProfiling(this.customerId).then(profiling => this.profiling = profiling);
      this.updateProfilingRequestResponse = new GenericResponse();
      this.updateProfilingRequestResponse.responseCode = 0;
      this.currentProfiling = new CustomerProfiling();
    }
  }

  async updateProfiling(idProfiling: number) {
    if (this.checkProfilingFieldsValid() === true) {
      this.updateProfilingRequestResponse = await this.profilingService.updateCustomerProfiling(idProfiling,
        this.customerId, this.currentProfiling.profession, this.currentProfiling.residenceCity,
        this.currentProfiling.residenceProvince, this.currentProfiling.workSegment, this.currentProfiling.currentJob,
        this.currentProfiling.birthCity, this.currentProfiling.birthResidence, this.currentProfiling.gender);
    } else {
      this.updateProfilingRequestResponse.responseCode = 422;
      this.requestResponseMessage = MessageConstants.MISSING_FIELDS;
    }
    if (this.updateProfilingRequestResponse.responseCode === 200) {
      this.requestResponseMessage = MessageConstants.PROFILING_UPDATE_SUCCESSFUL;
    } else if (this.updateProfilingRequestResponse.responseCode !== 422) {
      this.requestResponseMessage = MessageConstants.WEBSERVICE_ERROR +
        ' ' + this.updateProfilingRequestResponse.responseMessage;
    }
  }

  async addProfiling() {
    if (this.checkProfilingAddFields() === true) {
      this.updateProfilingRequestResponse = await this.profilingService.addCustomerProfiling(
        this.customerId, this.profession, this.residenceCity,
        this.residenceProvince, this.workSegment, this.currentJob,
        this.birthCity, this.birthResidence, this.gender);
    } else {
      this.updateProfilingRequestResponse.responseCode = 422;
      this.requestResponseMessage = MessageConstants.MISSING_FIELDS;
    }
    if (this.updateProfilingRequestResponse.responseCode === 200) {
      window.location.reload();
    }
  }

  logout() {
    this.cookieService.delete('Id');
    this.cookieService.delete('Name');
    this.cookieService.delete('token');
    this.router.navigate(['login']);
  }

}
