import { Component, EventEmitter, Output } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ContainerComponent } from './container/container.component';
import { ContainerModule } from './container/container.module';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ContainerModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'todo-app';

  darkTheme: boolean = true;
  @Output() darkThemeEvent = new EventEmitter<boolean>();

  setThemeEvent(darkTheme: boolean) {
    this.darkTheme = darkTheme;
    this.sendThemeEvent();
  }

  sendThemeEvent() {
    this.darkThemeEvent.emit(this.darkTheme);
  }
}
