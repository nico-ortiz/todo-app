import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DataInputBoxComponent } from './data-input-box.component';

describe('DataInputBoxComponent', () => {
  let component: DataInputBoxComponent;
  let fixture: ComponentFixture<DataInputBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DataInputBoxComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DataInputBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
