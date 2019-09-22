import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssiDetailsComponent } from './assi-details.component';

describe('AssiDetailsComponent', () => {
  let component: AssiDetailsComponent;
  let fixture: ComponentFixture<AssiDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssiDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssiDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
