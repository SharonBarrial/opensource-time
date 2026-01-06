import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {TheToolbarContentComponent} from "./public/components/the-toolbar-content/the-toolbar-content.component";
import {TheHomeContentComponent} from "./public/components/the-home-content/the-home-content.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TheToolbarContentComponent, TheHomeContentComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'open1conbaseservice';
}
