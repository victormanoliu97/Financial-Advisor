import { TestBed } from '@angular/core/testing';

import { CustomerLiabilitiesService } from './customer-liabilities.service';

describe('CustomerLiabilitiesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerLiabilitiesService = TestBed.get(CustomerLiabilitiesService);
    expect(service).toBeTruthy();
  });
});
