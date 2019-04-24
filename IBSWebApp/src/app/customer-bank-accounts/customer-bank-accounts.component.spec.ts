import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerBankAccountsComponent } from './customer-bank-accounts.component';

describe('CustomerBankAccountsComponent', () => {
  let component: CustomerBankAccountsComponent;
  let fixture: ComponentFixture<CustomerBankAccountsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerBankAccountsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerBankAccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
