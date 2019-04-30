import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import {AuthModule} from './auth/auth.module';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing/app-routing.module';
import { IndexMainComponent } from './index-main/index-main.component';
import { CustomerPanelComponent } from './customer-panel/customer-panel.component';
import { CustomerBankAccountsComponent } from './customer-bank-accounts/customer-bank-accounts.component';
import { UserProfilingComponent } from './user-profiling/user-profiling.component';
import {InputTextModule} from 'primeng/primeng';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import {VirtualScrollerModule} from 'primeng/virtualscroller';
import { BankAccountDetailsComponent } from './bank-account-details/bank-account-details.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexMainComponent,
    CustomerPanelComponent,
    CustomerBankAccountsComponent,
    UserProfilingComponent,
    BankAccountDetailsComponent,
  ],
  imports: [
    BsDropdownModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AuthModule,
    InputTextModule,
    VirtualScrollerModule,
  ],
  providers: [AuthModule, CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
