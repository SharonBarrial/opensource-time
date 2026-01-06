import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TheHomeContentComponent } from './the-home-content.component';

describe('TheHomeContentComponent', () => {
  let component: TheHomeContentComponent;
  let fixture: ComponentFixture<TheHomeContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TheHomeContentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TheHomeContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
