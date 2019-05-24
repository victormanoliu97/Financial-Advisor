import { Component, OnInit } from '@angular/core';
import {CustomerIncome} from '../shared/models/income/customer-income';
import {CookieService} from 'ngx-cookie-service';
import {CustomerIncomeService} from '../services/customer-income.service';
import {GenericResponse} from '../shared/models/responses/generic-response';
import {MessageConstants} from '../shared/models/constant/message-constants';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Router} from '@angular/router';
import {CustomerLiability} from '../shared/models/liabilities/customer-liability';
import {CustomerLiabilitiesService} from '../services/customer-liabilities.service';

@Component({
  selector: 'app-income-liabilities',
  templateUrl: './income-liabilities.component.html',
  styleUrls: ['./income-liabilities.component.css']
})
export class IncomeLiabilitiesComponent implements OnInit {
  incomes: CustomerIncome[];
  liabilities: CustomerLiability[];

  customerId: number = Number(this.cookieService.get('Id'));
  loggedUserName: string;

  incomeAmount: number;
  incomeSource: string;
  compressibleCosts: number;
  nonCompressibleCosts: number;

  liabilitiesAmount: number;
  liabilitiesSource: string;

  addIncomeRequestResponse: GenericResponse;
  updateIncomeRequestResponse: GenericResponse;
  deleteIncomeRequestResponse: GenericResponse;

  addLiabilityRequestResponse: GenericResponse;
  updateLiabilityRequestResponse: GenericResponse;
  deleteLiabilityRequestResponse: GenericResponse;


  requestResponseMessage: string;

  closeResult: string;


  constructor(private cookieService: CookieService, private incomeService: CustomerIncomeService,
              private liabilityService: CustomerLiabilitiesService, public modalService: NgbModal, private router: Router) { }

  ngOnInit() {
    if (this.cookieService.get('Id') === '') {
      this.router.navigate(['login']);
    } else {
      this.customerId = Number(this.cookieService.get('Id'));
      this.loggedUserName = this.cookieService.get('Name');
      this.incomeService.getCustomerIncomes(this.customerId).then(incomes => this.incomes = incomes);
      this.liabilityService.getCustomerLiabilities(this.customerId).then(liabilities => this.liabilities = liabilities);
      this.addIncomeRequestResponse = new GenericResponse();
      this.updateIncomeRequestResponse = new GenericResponse();
      this.addLiabilityRequestResponse = new GenericResponse();
      this.updateLiabilityRequestResponse = new GenericResponse();
      this.updateIncomeRequestResponse.responseCode = 0;
      this.addIncomeRequestResponse.responseCode = 0;
      this.updateLiabilityRequestResponse.responseCode = 0;
    }
  }

  private checkIncomeFieldsValid() {
    return !(this.incomeSource == null || this.incomeAmount == null);
  }

  private checkLiabilityFieldsValid() {
    return !(this.liabilitiesSource == null || this.liabilitiesAmount == null);
  }

  async updateIncome(incomeId: number) {
    if (this.checkIncomeFieldsValid() === true) {
      this.updateIncomeRequestResponse = await this.incomeService.updateCustomerIncome(this.incomeAmount, this.incomeSource,
        this.compressibleCosts, this.nonCompressibleCosts, incomeId, this.customerId);
    } else {
      this.updateIncomeRequestResponse.responseCode = 422;
      this.requestResponseMessage = MessageConstants.MISSING_FIELDS;
    }

    if (this.updateIncomeRequestResponse.responseCode === 200) {
      this.requestResponseMessage = MessageConstants.INCOME_UPDATE_SUCCESSFUL;
    }  else if (this.updateIncomeRequestResponse.responseCode !== 422) {
      this.requestResponseMessage = MessageConstants.WEBSERVICE_ERROR + ' ' + this.updateIncomeRequestResponse.responseMessage;
    }
  }

  async deleteIncome(incomeId: number) {
    this.deleteIncomeRequestResponse = await this.incomeService.deleteCustomerIncome(incomeId);
    if (this.deleteIncomeRequestResponse.responseCode === 200) {
      window.location.reload();
    }
  }

  async deleteLiability(liabilityId: number) {
    this.deleteLiabilityRequestResponse = await this.liabilityService.deleteCustomerLiability(liabilityId);
    if (this.deleteLiabilityRequestResponse.responseCode === 200) {
      window.location.reload();
    }
  }

  async updateLiability(liabilityId: number) {
    if (this.checkLiabilityFieldsValid() === true) {
      this.updateLiabilityRequestResponse = await this.liabilityService.updateCustomerLiability(liabilityId, this.liabilitiesAmount,
        this.liabilitiesSource, this.customerId);
    } else {
      this.updateLiabilityRequestResponse.responseCode = 422;
      this.requestResponseMessage = MessageConstants.MISSING_FIELDS;
    }

    if (this.updateLiabilityRequestResponse.responseCode === 200) {
      this.requestResponseMessage = MessageConstants.LIABILITY_UPDATE_SUCCESSFUL;
    } else if (this.updateLiabilityRequestResponse.responseCode !== 422) {
      this.requestResponseMessage = MessageConstants.WEBSERVICE_ERROR + ' ' + this.updateLiabilityRequestResponse.responseMessage;
    }
  }

  async addIncome() {
    if (this.checkIncomeFieldsValid() === true) {
      this.addIncomeRequestResponse = await this.incomeService.addCustomerIncome(this.incomeAmount, this.incomeSource,
        this.compressibleCosts, this.nonCompressibleCosts, this.customerId);
    } else {
      this.addIncomeRequestResponse.responseCode = 422;
      this.requestResponseMessage = MessageConstants.MISSING_FIELDS;
    }

    if (this.addIncomeRequestResponse.responseCode === 200) {
      window.location.reload();
    }
  }

  async addLiability() {
    if (this.checkLiabilityFieldsValid() === true) {
      this.addLiabilityRequestResponse = await this.liabilityService.addCustomerLiability(this.liabilitiesAmount,
        this.liabilitiesSource, this.customerId);
    } else {
      this.addLiabilityRequestResponse.responseCode = 422;
      this.requestResponseMessage = MessageConstants.MISSING_FIELDS;
    }

    if (this.addLiabilityRequestResponse.responseCode === 200) {
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
