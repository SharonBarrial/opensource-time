import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferManmagerComponent } from './offer-manmager.component';

describe('OfferManmagerComponent', () => {
  let component: OfferManmagerComponent;
  let fixture: ComponentFixture<OfferManmagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OfferManmagerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OfferManmagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
