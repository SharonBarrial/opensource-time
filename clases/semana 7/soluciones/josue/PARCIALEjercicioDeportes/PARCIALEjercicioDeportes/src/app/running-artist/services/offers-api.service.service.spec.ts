import { TestBed } from '@angular/core/testing';

import { OffersApiServiceService } from './offers-api.service.service';

describe('OffersApiServiceService', () => {
  let service: OffersApiServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OffersApiServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
