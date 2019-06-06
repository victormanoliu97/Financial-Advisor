import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ServerService} from './server.service';

@Injectable({
  providedIn: 'root'
})
export class FinancialInstrumentsService {

  getStocksUrl = 'http://localhost:5555/get-stocks';
  getForexUrl = 'http://localhost:5555/get-forex';

  constructor(private http: HttpClient, public serverService: ServerService) { }

  async getStocks(): Promise<any> {
    return this.http.get(this.getStocksUrl, {headers: this.serverService.requestHeaders}).toPromise<any>();
  }

  async getForex(): Promise<any> {
    return this.http.get(this.getForexUrl, {headers: this.serverService.requestHeaders}).toPromise<any>();
  }
}
