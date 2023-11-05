import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewblogComponent } from './newblog.component';

describe('NewblogComponent', () => {
  let component: NewblogComponent;
  let fixture: ComponentFixture<NewblogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewblogComponent]
    });
    fixture = TestBed.createComponent(NewblogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
