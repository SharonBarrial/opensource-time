import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMoviesViewComponent } from './list-movies-view.component';

describe('ListMoviesViewComponent', () => {
  let component: ListMoviesViewComponent;
  let fixture: ComponentFixture<ListMoviesViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListMoviesViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListMoviesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
