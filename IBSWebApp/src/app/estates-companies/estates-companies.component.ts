import { Component, OnInit } from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Router} from '@angular/router';
import {CustomerEstate} from '../shared/models/estate/customer-estate';
import {CustomerCompanies} from '../shared/models/companies/customer-companies';
import {CustomerEstatesService} from '../services/customer-estates.service';
import {CustomerCompaniesService} from '../services/customer-companies.service';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {MessageConstants} from '../shared/models/constant/message-constants';

@Component({
  selector: 'app-estates-companies',
  templateUrl: './estates-companies.component.html',
  styleUrls: ['./estates-companies.component.css']
})
export class EstatesCompaniesComponent implements OnInit {
  estates: CustomerEstate[];
  companies: CustomerCompanies[];

  customerId: number = Number(this.cookieService.get('Id'));
  loggedUserName: string;

  estateName: string;
  estateDescription: string;
  estateType: string;
  estateValue: number;

  companyName: string;

  requestResponseMessage: string;
  closeResult: string;

  updateEstateRequestResponse: GenericResponse;
  addEstateRequestResponse: GenericResponse;
  deleteEstateRequestResponse: GenericResponse;

  updateCompanyRequestResponse: GenericResponse;
  addCompanyRequestResponse: GenericResponse;
  deleteCompanyRequestResponse: GenericResponse;
  companyDescription: string;
  companyType: string;
  companyRevenue: number;


  constructor(private cookieService: CookieService, public modalService: NgbModal, private router: Router,
              public estateService: CustomerEstatesService, public companyService: CustomerCompaniesService) { }

  ngOnInit() {
    if (this.cookieService.get('Id') === '') {
      this.router.navigate(['login']);
    } else {
      this.customerId = Number(this.cookieService.get('Id'));
      this.loggedUserName = this.cookieService.get('Name');
      this.estateService.getCustomerEstates(this.customerId).then(estates => this.estates = estates);
      this.companyService.getCustomerCompanies(this.customerId).then(companies => this.companies = companies);
      this.updateEstateRequestResponse = new GenericResponse();
      this.addEstateRequestResponse = new GenericResponse();
      this.deleteEstateRequestResponse = new GenericResponse();
      this.updateCompanyRequestResponse = new GenericResponse();
      this.addCompanyRequestResponse = new GenericResponse();
      this.deleteCompanyRequestResponse = new GenericResponse();
      this.updateEstateRequestResponse.responseCode = 0;
      this.updateCompanyRequestResponse.responseCode = 0;
      this.addCompanyRequestResponse.responseCode = 0;
      this.addEstateRequestResponse.responseCode = 0;
    }
  }

  private checkEstateFieldsValid() {
    return !(this.estateName == null || this.estateType == null || this.estateValue == null);
  }

  private checkCompanyFieldsValid() {
    return !(this.companyName == null || this.companyType == null || this.companyRevenue == null);
  }

  async updateEstate(estateId: number) {
    if (this.checkEstateFieldsValid() === true) {
      this.updateEstateRequestResponse = await this.estateService.updateCustomerEstate(estateId, this.estateName, this.estateDescription,
        this.estateType, this.estateValue, this.customerId);
    } else {
      this.updateEstateRequestResponse.responseCode = 422;
      this.updateEstateRequestResponse.responseMessage = MessageConstants.MISSING_FIELDS;
    }
    if (this.updateEstateRequestResponse.responseCode === 200) {
      this.requestResponseMessage =  MessageConstants.ESTATE_UPDATE_SUCCESSFUL;
    } else if (this.updateEstateRequestResponse.responseCode !== 422) {
      this.requestResponseMessage = MessageConstants.WEBSERVICE_ERROR + ' ' + this.updateEstateRequestResponse.responseMessage;
    }
  }

  async updateCompany(idCompany: number) {
    if (this.checkCompanyFieldsValid() === true) {
      this.updateCompanyRequestResponse = await this.companyService.updateCustomerCompany(idCompany,
        this.companyName, this.companyDescription,
        this.companyDescription, this.companyRevenue, this.customerId);
    } else {
      this.updateCompanyRequestResponse.responseCode = 422;
      this.updateCompanyRequestResponse.responseMessage = MessageConstants.MISSING_FIELDS;
    }
    if (this.updateCompanyRequestResponse.responseCode === 200) {
      this.requestResponseMessage =  MessageConstants.COMPANY_UPDATE_SUCCESSFUL;
    } else if (this.updateCompanyRequestResponse.responseCode !== 422) {
      this.requestResponseMessage = MessageConstants.WEBSERVICE_ERROR + ' ' + this.updateEstateRequestResponse.responseMessage;
    }
  }

  async deleteCompany(idCompany: number) {
    this.deleteCompanyRequestResponse = await this.companyService.deleteCustomerCompany(idCompany);
    if (this.deleteCompanyRequestResponse.responseCode === 200) {
      window.location.reload();
    }
  }

  async deleteEstate(estateId: number) {
    this.deleteEstateRequestResponse = await this.estateService.deleteCustomerEstate(estateId);
    if (this.deleteEstateRequestResponse.responseCode === 200) {
      window.location.reload();
    }
  }

  async addCompany() {
    if (this.checkCompanyFieldsValid() === true) {
      this.addCompanyRequestResponse = await this.companyService.addCustomerCompany(this.companyName, this.companyDescription,
        this.companyType, this.companyRevenue, this.customerId);
    } else {
      this.addCompanyRequestResponse.responseCode = 422;
      this.requestResponseMessage = MessageConstants.MISSING_FIELDS;
    }
    if (this.addCompanyRequestResponse.responseCode === 200) {
      window.location.reload();
    }
  }

  async addEstate() {
    if (this.checkEstateFieldsValid() === true) {
      this.addEstateRequestResponse = await this.estateService.addCustomerEstate(this.estateName, this.estateDescription,
      this.estateType, this.estateValue, this.customerId);
    } else {
      this.addEstateRequestResponse.responseCode = 422;
      this.requestResponseMessage = MessageConstants.MISSING_FIELDS;
    }
    if(this.addEstateRequestResponse.responseCode === 200) {
      window.location.reload();
    }
  }

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
}
