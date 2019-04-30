import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-customer-panel',
  templateUrl: './customer-panel.component.html',
  styleUrls: ['./customer-panel.component.css']
})
export class CustomerPanelComponent implements OnInit {
  loggedUserName = null;

  constructor(private cookieService: CookieService) { }

  ngOnInit() {
    this.loggedUserName = this.cookieService.get('Name');
  }

}
