import { TestBed } from '@angular/core/testing';

import { CustomerProfilingService } from './customer-profiling.service';

describe('CustomerProfilingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerProfilingService = TestBed.get(CustomerProfilingService);
    expect(service).toBeTruthy();
  });
});
