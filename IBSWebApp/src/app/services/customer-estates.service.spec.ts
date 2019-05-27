import { TestBed } from '@angular/core/testing';

import { CustomerEstatesService } from './customer-estates.service';

describe('CustomerEstatesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerEstatesService = TestBed.get(CustomerEstatesService);
    expect(service).toBeTruthy();
  });
});
