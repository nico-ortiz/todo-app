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
  allTaskList: Task[] = [];
  completedTaskList: Task[] = [];
  activeTaskList: Task[] = [];

  /* Variables to show tasks */
  all: boolean = true;
  active: boolean = false;
  completed: boolean = false;

  showTasks() {
    if (this.all) {
      this.taskList = this.allTaskList;
    } else if (this.active) {
      this.taskList = this.activeTaskList;
    } else {
      this.taskList = this.completedTaskList;
    }
  }

  receiveTask(task: Task) {
    this.receivedTask = task;
    this.addTask(task);
  }

  addTask(task: Task) {
    this.allTaskList.push(task);
    this.activeTaskList.push(task);
    this.showTasks();
  }

  allBtnHandle() {
    this.all = true;
    this.active = false;
    this.completed = false;
    this.showTasks();
  }

  activeBtnHandle() {
    this.all = false;
    this.active = true;
    this.completed = false;
    this.showTasks();
  }

  completedBtnHandle() {
    this.all = false;
    this.active = false;
    this.completed = true;
    this.showTasks();
  }

  clearCompletedTasks() {
    this.completedTaskList = [];
    this.allTaskList = this.clearAllCompletedTasks();
    this.showTasks();
  }

  clearAllCompletedTasks() {
    return this.allTaskList.filter(task => 
      task.status === true
    );
  }

  addCompletedTask(task: Task) {
    if (task.status === true) {
      task.status = false;
      this.completedTaskList.push(task);
      this.deleteTask(this.activeTaskList, task);
    }
  }

  removeCompletedTask(task: Task) {
    if (task.status === false) {
      task.status = true;
      this.activeTaskList.push(task);
      this.deleteTask(this.completedTaskList, task);
    }
  }

  deleteTask(list: Task[], task: Task) {
    const index : number = list.indexOf(task);
    if (index !== -1) {
      list.splice(index, 1);
    }
  } 
}
