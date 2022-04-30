import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserComplainComponent } from './user-complain.component';

describe('UserComplainComponent', () => {
  let component: UserComplainComponent;
  let fixture: ComponentFixture<UserComplainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserComplainComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserComplainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
