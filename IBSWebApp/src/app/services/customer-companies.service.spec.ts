import { TestBed } from '@angular/core/testing';

import { CustomerCompaniesService } from './customer-companies.service';

describe('CustomerCompaniesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerCompaniesService = TestBed.get(CustomerCompaniesService);
    expect(service).toBeTruthy();
  });
});
