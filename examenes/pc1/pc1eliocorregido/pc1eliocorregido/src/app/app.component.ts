import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {TheHeaderComponentComponent} from "./public/components/the-header-component/the-header-component.component";
import {TheFooterComponentComponent} from "./public/components/the-footer-component/the-footer-component.component";
import {MealCardInformationComponent} from "./meal/components/meal-card-information/meal-card-information.component";
import {MealFilterComponent} from "./meal/components/meal-filter/meal-filter.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TheHeaderComponentComponent, TheFooterComponentComponent, MealCardInformationComponent, MealFilterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pc1eliocorregido';
}
