import {Component, Input, OnInit} from '@angular/core';
import {Meal} from "../../models/meal.model";
import {MealService} from "../../services/meal.service";
import {MatCardModule} from "@angular/material/card";

@Component({
  selector: 'app-meal-card-information',
  standalone: true,
  imports: [
    MatCardModule
  ],
  templateUrl: './meal-card-information.component.html',
  styleUrl: './meal-card-information.component.css'
})
export class MealCardInformationComponent {

  @Input() currentlyMeal?:Meal;

}
