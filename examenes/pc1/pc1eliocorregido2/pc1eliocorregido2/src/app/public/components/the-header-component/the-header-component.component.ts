import { Component } from '@angular/core';
import {MatToolbar} from "@angular/material/toolbar";

@Component({
  selector: 'app-the-header-component',
  standalone: true,
  imports: [
    MatToolbar
  ],
  templateUrl: './the-header-component.component.html',
  styleUrl: './the-header-component.component.css'
})
export class TheHeaderComponentComponent {

}
