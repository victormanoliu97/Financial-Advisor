import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserProfilingComponent } from './user-profiling.component';

describe('UserProfilingComponent', () => {
  let component: UserProfilingComponent;
  let fixture: ComponentFixture<UserProfilingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserProfilingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserProfilingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
