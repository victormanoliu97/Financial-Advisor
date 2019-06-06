import { TestBed } from '@angular/core/testing';

import { FinancialInstrumentsService } from './financial-instruments.service';

describe('FinancialInstrumentsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FinancialInstrumentsService = TestBed.get(FinancialInstrumentsService);
    expect(service).toBeTruthy();
  });
});
