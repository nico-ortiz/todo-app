import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Task } from '../../../task';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-data-input-box',
  templateUrl: './data-input-box.component.html',
  styleUrl: './data-input-box.component.css'
})
export class DataInputBoxComponent {
  taskFieldForm = new FormControl('', Validators.required);

  @Output() taskEvent = new EventEmitter<Task>();

  sendTask() {
    if (!this.taskFieldForm.valid) {
      document.querySelector('.input-container')?.classList.add('invalid');
    } else {
      document.querySelector('.input-container')?.classList.remove('invalid');
      let task: Task = {
        description: this.taskFieldForm.value || '',
        status: true
      };

      this.taskFieldForm.reset();
      this.taskEvent.emit(task);
    }
  }

  @Input() darkTheme! : boolean;

  darkThemeDataInputBoxHandle() {
    if (this.darkTheme) {
      document.querySelector('.input-container')?.classList.add('dark');
    } else {
      document.querySelector('.input-container')?.classList.remove('dark');
    }
  }
}