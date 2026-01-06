import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MentalStateExamsPageComponent } from './mental-state-exams-page.component';

describe('MentalStateExamsPageComponent', () => {
  let component: MentalStateExamsPageComponent;
  let fixture: ComponentFixture<MentalStateExamsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MentalStateExamsPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MentalStateExamsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
