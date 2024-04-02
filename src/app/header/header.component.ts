import { Component } from '@angular/core';
import { DataInputBoxComponent } from '../data-input-box/data-input-box.component';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [DataInputBoxComponent],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  lightTheme: boolean = true;
  
  constructor(private dataInputBoxCmp: DataInputBoxComponent) {
  }

  buttonThemeHandle() {
    if (this.lightTheme) {
      /* Active dark theme */
      document.querySelector('.header')?.classList.toggle('dark');
      this.dataInputBoxCmp.changeDataInputBoxTheme();
      
    } else {
      document.querySelector('.header')?.classList.toggle('dark');
      this.dataInputBoxCmp.changeDataInputBoxTheme();
    }
    this.lightTheme = !this.lightTheme;
  }

}
