import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrl: './container.component.css'
})
export class ContainerComponent {
  darkTheme! : boolean;

    @Output() darkThemeEvent = new EventEmitter<boolean>();

    setDarkTheme(darkTheme: boolean) {
      this.darkTheme = darkTheme;
      this.sendDarkTheme(this.darkTheme);
    }

    sendDarkTheme(darkTheme: boolean) {
      this.darkThemeEvent.emit(darkTheme);
    }
}
