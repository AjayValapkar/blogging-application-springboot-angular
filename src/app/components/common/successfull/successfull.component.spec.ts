import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessfullComponent } from './successfull.component';

describe('SuccessfullComponent', () => {
  let component: SuccessfullComponent;
  let fixture: ComponentFixture<SuccessfullComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SuccessfullComponent]
    });
    fixture = TestBed.createComponent(SuccessfullComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
