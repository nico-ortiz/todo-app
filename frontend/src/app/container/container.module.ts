import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContainerComponent } from './container.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TaskListComponent } from './task-list/task-list.component';
import { DataInputBoxComponent } from './task-list/data-input-box/data-input-box.component';

@NgModule({
  declarations: [
    ContainerComponent,
    HeaderComponent,
    TaskListComponent,
    DataInputBoxComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  exports: [ContainerComponent]
})
export class ContainerModule { }
