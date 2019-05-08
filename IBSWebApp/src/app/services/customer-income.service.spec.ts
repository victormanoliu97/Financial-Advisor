import { TestBed } from '@angular/core/testing';

import { CustomerIncomeService } from './customer-income.service';

describe('CustomerIncomeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerIncomeService = TestBed.get(CustomerIncomeService);
    expect(service).toBeTruthy();
  });
});
