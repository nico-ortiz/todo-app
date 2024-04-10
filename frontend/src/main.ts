import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';

function setTheme(darkTheme: boolean) {
  if (darkTheme) {
    console.log("dark");
  } else {
    console.log("light");
  }
}

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
