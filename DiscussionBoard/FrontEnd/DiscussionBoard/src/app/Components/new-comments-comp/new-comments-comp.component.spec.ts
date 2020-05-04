import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCommentsCompComponent } from './new-comments-comp.component';

describe('NewCommentsCompComponent', () => {
  let component: NewCommentsCompComponent;
  let fixture: ComponentFixture<NewCommentsCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewCommentsCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCommentsCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
