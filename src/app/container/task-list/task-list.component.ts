import { Component, Input } from '@angular/core';
import { Task } from '../../task';

@Component({
  selector: 'app-task-list',
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

  @Input() darkTheme!: boolean;

  darkThemeTaskListHandle() {
    if (this.darkTheme) {
      document.querySelector('.task-list')?.classList.add('dark');
      console.log("dark");
    } else {
      document.querySelector('.task-list')?.classList.remove('dark');
      console.log("light");
    }
  }

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
  
  removeTask(task: Task) {
    this.deleteTask(this.allTaskList, task);
    this.deleteTask(this.activeTaskList, task);
    this.deleteTask(this.completedTaskList, task);
    this.deleteTask(this.taskList, task);
    this.showTasks();
  }
}
