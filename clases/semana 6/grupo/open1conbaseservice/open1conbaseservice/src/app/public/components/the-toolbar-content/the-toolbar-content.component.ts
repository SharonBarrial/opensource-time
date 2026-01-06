import { Component } from '@angular/core';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {Router, RouterLink} from "@angular/router";

@Component({
  selector: 'app-the-toolbar-content',
  standalone: true,
  imports: [
    MatToolbarModule,
    MatIconButton,
    MatIconModule,
    MatButton,
    RouterLink,

  ],
  templateUrl: './the-toolbar-content.component.html',
  styleUrl: './the-toolbar-content.component.css'
})
export class TheToolbarContentComponent {
  constructor(private router:Router) {
  }

  home(){
    this.router.navigateByUrl('/home');
  }

}
