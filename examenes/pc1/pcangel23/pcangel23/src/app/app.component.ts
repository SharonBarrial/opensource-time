import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {TheFooterContentComponent} from "./public/components/the-footer-content/the-footer-content.component";
import {TheHeaderContentComponent} from "./public/components/the-header-content/the-header-content.component";
import {GridJokesCardsComponent} from "./jokes/components/grid-jokes-cards/grid-jokes-cards.component";
import {JokesCardComponent} from "./jokes/components/jokes-card/jokes-card.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TheFooterContentComponent, TheHeaderContentComponent, GridJokesCardsComponent, JokesCardComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pcangel23';
}
