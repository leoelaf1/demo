import { TestBed, inject } from '@angular/core/testing';
import { CleanService } from './clean.service';

describe('CleanService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CleanService]
    });
  });

  it('should be created', inject([CleanService], (service: CleanService) => {
    expect(service).toBeTruthy();
  }));
});
