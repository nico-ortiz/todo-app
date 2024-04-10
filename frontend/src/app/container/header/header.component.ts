import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  darkTheme: boolean = false;
  @Output() changeThemeEvent = new EventEmitter<boolean>();

  buttonThemeHandle() {
    this.darkTheme = !this.darkTheme;
    if (this.darkTheme) {
      /* Active dark theme */
      document.querySelector('.header')?.classList.add('dark');     
    } else {
      /* Active light theme */
      document.querySelector('.header')?.classList.remove('dark');
    }
    this.changeThemeEvent.emit(this.darkTheme);
  }

}
