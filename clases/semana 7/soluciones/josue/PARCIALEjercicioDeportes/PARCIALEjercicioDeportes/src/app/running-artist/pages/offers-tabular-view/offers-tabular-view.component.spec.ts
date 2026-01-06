import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OffersTabularViewComponent } from './offers-tabular-view.component';

describe('OffersTabularViewComponent', () => {
  let component: OffersTabularViewComponent;
  let fixture: ComponentFixture<OffersTabularViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OffersTabularViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OffersTabularViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
