import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountStatisticsComponent } from './account-statistics.component';

describe('AccountStatisticsComponent', () => {
  let component: AccountStatisticsComponent;
  let fixture: ComponentFixture<AccountStatisticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccountStatisticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
