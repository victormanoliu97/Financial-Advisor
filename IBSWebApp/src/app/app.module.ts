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
import { UserProfilingComponent } from './user-profiling/user-profiling.component';
import {ChartModule, InputTextModule} from 'primeng/primeng';
import {DropdownModule} from 'primeng/dropdown';
import {VirtualScrollerModule} from 'primeng/virtualscroller';
import {TooltipModule} from 'ngx-bootstrap';
import { IncomeLiabilitiesComponent } from './income-liabilities/income-liabilities.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { EstatesCompaniesComponent } from './estates-companies/estates-companies.component';
import { AccountStatisticsComponent } from './account-statistics/account-statistics.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    IndexMainComponent,
    CustomerPanelComponent,
    UserProfilingComponent,
    IncomeLiabilitiesComponent,
    EstatesCompaniesComponent,
    AccountStatisticsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AuthModule,
    InputTextModule,
    VirtualScrollerModule,
    TooltipModule,
    NgbModule,
    ChartModule,
    DropdownModule,
    BrowserAnimationsModule,
  ],
  providers: [AuthModule, CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
