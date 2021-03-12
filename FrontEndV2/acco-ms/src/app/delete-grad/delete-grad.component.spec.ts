import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteGradComponent } from './delete-grad.component';

describe('DeleteGradComponent', () => {
  let component: DeleteGradComponent;
  let fixture: ComponentFixture<DeleteGradComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteGradComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteGradComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
