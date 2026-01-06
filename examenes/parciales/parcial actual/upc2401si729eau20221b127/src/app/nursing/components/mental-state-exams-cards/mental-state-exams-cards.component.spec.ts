import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MentalStateExamsCardsComponent } from './mental-state-exams-cards.component';

describe('MentalStateExamsCardsComponent', () => {
  let component: MentalStateExamsCardsComponent;
  let fixture: ComponentFixture<MentalStateExamsCardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MentalStateExamsCardsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MentalStateExamsCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
