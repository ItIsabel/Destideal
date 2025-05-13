import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeadernfiltersComponent } from './headernfilters.component';

describe('HeadernfiltersComponent', () => {
  let component: HeadernfiltersComponent;
  let fixture: ComponentFixture<HeadernfiltersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HeadernfiltersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HeadernfiltersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
