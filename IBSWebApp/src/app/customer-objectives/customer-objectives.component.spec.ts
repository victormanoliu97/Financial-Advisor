import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerObjectivesComponent } from './customer-objectives.component';

describe('CustomerObjectivesComponent', () => {
  let component: CustomerObjectivesComponent;
  let fixture: ComponentFixture<CustomerObjectivesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerObjectivesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerObjectivesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
