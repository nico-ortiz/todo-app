import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Task } from '../../task';

@Component({
  selector: 'app-data-input-box',
  templateUrl: './data-input-box.component.html',
  styleUrl: './data-input-box.component.css'
})
export class DataInputBoxComponent {
  taskForm = new FormControl('');

  @Output() taskEvent = new EventEmitter<Task>();

  sendTask() {
    let task: Task = {
      description: this.taskForm.value || '',
      status: true
    }; 

    this.taskForm.reset();
    this.taskEvent.emit(task);
  }

  @Input() darkTheme! : boolean;

  darkThemeDataInputBoxHandle() {
    if (this.darkTheme) {

    } else {
      
    }
  }
}
