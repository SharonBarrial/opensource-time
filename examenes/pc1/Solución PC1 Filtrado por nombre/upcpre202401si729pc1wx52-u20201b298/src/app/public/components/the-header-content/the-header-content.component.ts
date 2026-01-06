import { Component } from '@angular/core';
import {MatToolbar} from "@angular/material/toolbar";

@Component({
  selector: 'app-the-header-content',
  standalone: true,
  imports: [
    MatToolbar
  ],
  templateUrl: './the-header-content.component.html',
  styleUrl: './the-header-content.component.css'
})
export class TheHeaderContentComponent {

}
