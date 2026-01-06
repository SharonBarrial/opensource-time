import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MealCardInformationComponent } from './meal-card-information.component';

describe('MealCardInformationComponent', () => {
  let component: MealCardInformationComponent;
  let fixture: ComponentFixture<MealCardInformationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MealCardInformationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MealCardInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
