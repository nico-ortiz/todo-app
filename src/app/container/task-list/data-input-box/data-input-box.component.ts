import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Task } from '../../../task';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-data-input-box',
  templateUrl: './data-input-box.component.html',
  styleUrl: './data-input-box.component.css'
})
export class DataInputBoxComponent {
  taskFieldForm = new FormControl('');

  @Output() taskEvent = new EventEmitter<Task>();

  sendTask() {
    let task: Task = {
      description: this.taskFieldForm.value || '',
      status: true
    };

    this.taskFieldForm.reset();
    this.taskEvent.emit(task);
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