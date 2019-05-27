import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstatesCompaniesComponent } from './estates-companies.component';

describe('EstatesCompaniesComponent', () => {
  let component: EstatesCompaniesComponent;
  let fixture: ComponentFixture<EstatesCompaniesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstatesCompaniesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstatesCompaniesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
