import { TestBed } from '@angular/core/testing';

import { CustomerObjectiveService } from './customer-objective.service';

describe('CustomerObjectiveService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerObjectiveService = TestBed.get(CustomerObjectiveService);
    expect(service).toBeTruthy();
  });
});
