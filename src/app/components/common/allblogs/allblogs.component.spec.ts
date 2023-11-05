import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllblogsComponent } from './allblogs.component';

describe('AllblogsComponent', () => {
  let component: AllblogsComponent;
  let fixture: ComponentFixture<AllblogsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllblogsComponent]
    });
    fixture = TestBed.createComponent(AllblogsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
