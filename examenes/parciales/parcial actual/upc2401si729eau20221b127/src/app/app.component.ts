/**
 * This file defines the main component that imports the ToolbarContentComponent
 * @summary Main App Component
 * @author Salvador Antonio Salinas Torres
 */

import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ToolbarContentComponent } from "./public/components/toolbar-content/toolbar-content.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ToolbarContentComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'upc2401si729eau20221b127';

  constructor() {}

}
