import { TestBed } from '@angular/core/testing';

import { CustomerBankAccountsService } from './customer-bank-accounts.service';

describe('CustomerBankAccountsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerBankAccountsService = TestBed.get(CustomerBankAccountsService);
    expect(service).toBeTruthy();
  });
});
