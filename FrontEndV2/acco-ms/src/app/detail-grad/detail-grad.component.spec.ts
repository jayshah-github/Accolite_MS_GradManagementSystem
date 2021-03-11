import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailGradComponent } from './detail-grad.component';

describe('DetailGradComponent', () => {
  let component: DetailGradComponent;
  let fixture: ComponentFixture<DetailGradComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailGradComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailGradComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
