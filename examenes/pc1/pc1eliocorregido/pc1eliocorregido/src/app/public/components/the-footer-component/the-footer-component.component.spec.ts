import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TheFooterComponentComponent } from './the-footer-component.component';

describe('TheFooterComponentComponent', () => {
  let component: TheFooterComponentComponent;
  let fixture: ComponentFixture<TheFooterComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TheFooterComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TheFooterComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
