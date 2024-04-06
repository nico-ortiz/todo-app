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

  darkTheme!: boolean;

  setThemeEvent(darkTheme: boolean) {
    this.darkTheme = darkTheme;
    
    if (darkTheme) {
      document.querySelector('section')?.classList.add('dark');
    } else {
      document.querySelector('section')?.classList.remove('dark');
    }
  }
}
