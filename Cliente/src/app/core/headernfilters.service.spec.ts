import { TestBed } from '@angular/core/testing';

import { HeadernfiltersService } from './headernfilters.service';

describe('HeadernfiltersService', () => {
  let service: HeadernfiltersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HeadernfiltersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
