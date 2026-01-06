import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GridJokesCardsComponent } from './grid-jokes-cards.component';

describe('GridJokesCardsComponent', () => {
  let component: GridJokesCardsComponent;
  let fixture: ComponentFixture<GridJokesCardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GridJokesCardsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GridJokesCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
