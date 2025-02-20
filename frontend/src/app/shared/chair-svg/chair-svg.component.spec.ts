import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChairSvgComponent } from './chair-svg.component';

describe('ChairSvgComponent', () => {
  let component: ChairSvgComponent;
  let fixture: ComponentFixture<ChairSvgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChairSvgComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChairSvgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
