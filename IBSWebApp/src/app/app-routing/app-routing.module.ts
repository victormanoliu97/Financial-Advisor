import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from '../auth/login/login.component';
import {IndexMainComponent} from '../index-main/index-main.component';
import {UserProfilingComponent} from '../user-profiling/user-profiling.component';
import {CustomerPanelComponent} from '../customer-panel/customer-panel.component';
import {CustomerBankAccountsComponent} from '../customer-bank-accounts/customer-bank-accounts.component';
import {BankAccountDetailsComponent} from '../bank-account-details/bank-account-details.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'index',
    component: IndexMainComponent
  },
  {
    path: 'user-profiling',
    component: UserProfilingComponent
  },
  {
    path: 'customer-panel',
    component: CustomerPanelComponent
  },
  {
    path: 'bank-accounts',
    component: CustomerBankAccountsComponent
  },
  {
    path: 'account-details',
    component: BankAccountDetailsComponent
  },
  {
    path: '',
    redirectTo: 'index',
    pathMatch: 'full'
  },
  {
    path: '*',
    redirectTo: 'index',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
