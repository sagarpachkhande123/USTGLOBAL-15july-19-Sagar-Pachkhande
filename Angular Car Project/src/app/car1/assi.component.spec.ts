import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssiComponent } from './assi.component';

describe('AssiComponent', () => {
  let component: AssiComponent;
  let fixture: ComponentFixture<AssiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
