import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogslistComponent } from './blogslist.component';

describe('BlogslistComponent', () => {
  let component: BlogslistComponent;
  let fixture: ComponentFixture<BlogslistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BlogslistComponent]
    });
    fixture = TestBed.createComponent(BlogslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
