import { TestBed } from '@angular/core/testing';

import { ExaminersApiService } from './examiners-api.service';

describe('ExaminersApiService', () => {
  let service: ExaminersApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExaminersApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
