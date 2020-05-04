import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactsAndLocationsComponent } from './contacts-and-locations.component';

describe('ContactsAndLocationsComponent', () => {
  let component: ContactsAndLocationsComponent;
  let fixture: ComponentFixture<ContactsAndLocationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContactsAndLocationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactsAndLocationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
