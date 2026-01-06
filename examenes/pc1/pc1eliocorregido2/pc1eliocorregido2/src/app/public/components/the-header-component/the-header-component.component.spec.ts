import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TheHeaderComponentComponent } from './the-header-component.component';

describe('TheHeaderComponentComponent', () => {
  let component: TheHeaderComponentComponent;
  let fixture: ComponentFixture<TheHeaderComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TheHeaderComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TheHeaderComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
