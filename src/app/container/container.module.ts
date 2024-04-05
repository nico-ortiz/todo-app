import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContainerComponent } from './container.component';
import { DataInputBoxComponent } from './data-input-box/data-input-box.component';
import { HeaderComponent } from './header/header.component';
import { TaskListComponent } from './task-list/task-list.component';



@NgModule({
  declarations: [
    ContainerComponent,
    DataInputBoxComponent,
    HeaderComponent,
    TaskListComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [ContainerComponent]
})
export class ContainerModule { }
