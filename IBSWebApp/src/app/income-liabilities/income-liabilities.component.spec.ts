import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IncomeLiabilitiesComponent } from './income-liabilities.component';

describe('IncomeLiabilitiesComponent', () => {
  let component: IncomeLiabilitiesComponent;
  let fixture: ComponentFixture<IncomeLiabilitiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncomeLiabilitiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncomeLiabilitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
