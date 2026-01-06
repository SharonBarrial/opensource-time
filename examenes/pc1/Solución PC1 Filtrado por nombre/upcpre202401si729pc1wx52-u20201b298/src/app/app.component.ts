import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {TheHeaderContentComponent} from "./public/components/the-header-content/the-header-content.component";
import {TheFooterContentComponent} from "./public/components/the-footer-content/the-footer-content.component";
import {TableCharactersComponent} from "./character/components/table-characters/table-characters.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TheHeaderContentComponent, TheFooterContentComponent, TableCharactersComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'upcpre202401si729pc1wx52-u20201b298';
}
