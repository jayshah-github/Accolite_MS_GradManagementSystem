import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddGradComponent } from './add-grad.component';

describe('AddGradComponent', () => {
  let component: AddGradComponent;
  let fixture: ComponentFixture<AddGradComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddGradComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddGradComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
