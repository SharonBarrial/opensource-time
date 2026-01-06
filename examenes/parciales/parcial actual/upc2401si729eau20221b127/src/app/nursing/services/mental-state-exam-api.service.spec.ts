import { TestBed } from '@angular/core/testing';

import { MentalStateExamApiService } from './mental-state-exam-api.service';

describe('MentalStateExamApiService', () => {
  let service: MentalStateExamApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MentalStateExamApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
