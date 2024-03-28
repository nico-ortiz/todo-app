import { Component } from '@angular/core';
import { Task } from '../task';
import { DataInputBoxComponent } from '../data-input-box/data-input-box.component';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [DataInputBoxComponent],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css'
})
export class TaskListComponent {
  receivedTask!: Task;
  taskList: Task[] = [];

  receiveTask(task: Task) {
    this.receivedTask = task;
    this.addTask(task);
  }

  addTask(task: Task) {
    this.taskList.push(task);
  }
}
