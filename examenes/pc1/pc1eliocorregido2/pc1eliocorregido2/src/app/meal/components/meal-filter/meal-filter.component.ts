import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {FormsModule} from "@angular/forms";
import {MealCardInformationComponent} from "../meal-card-information/meal-card-information.component";
import {Meal} from "../../models/meal.model";
import {MealService} from "../../services/meal.service";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-meal-filter',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInput,
    FormsModule,
    MealCardInformationComponent,
    MatButton
  ],
  templateUrl: './meal-filter.component.html',
  styleUrl: './meal-filter.component.css'
})
export class MealFilterComponent implements OnInit {
  mealData: any;
  meal?: Meal;
  meals: Meal[]=[];
  filteredMeals: Meal[] = [];
  instructionsFilter?:string;
  letter: string[]=['1','a','b'];
  constructor(private mealService: MealService) {}

  ngOnInit() {
    this.getRandomMeal();
    this.getAllMealsByFirstNameLetter()
  }

  getRandomMeal(){
    this.mealService.getMealRandom().subscribe((data:any)=>{
      this.meal = new Meal(data.meals[0].strMealThumb,
        data.meals[0].strMeal,
        data.meals[0].strInstructions,
        data.meals[0].strIngredient1,
        data.meals[0].strIngredient2,
        data.meals[0].strCategory)
    });
  }
  getAllMealsByFirstNameLetter(){
    for (let i = 0; i < this.letter.length; i++){
      this.mealService.getAllMealForFirstNameLetter(this.letter[i].toString()).subscribe((data:any)=>{
        data.meals.forEach((meal:any) => {
          this.mealData = new Meal(meal.strMealThumb,
            meal.strMeal,
            meal.strInstructions,
            meal.strIngredient1,
            meal.strIngredient2,
            meal.strCategory);
          this.meals.push(this.mealData);
        });
      })
    }
    console.log(this.meals);
  }

  filterMealsByInstructions(instruction?: string) {
    this.filteredMeals = this.filteredMeals.filter(meal =>
      meal.instructions.includes(instruction)
    );
    console.log(this.filteredMeals);
    this.meal=this.filteredMeals[0];
    this.filteredMeals=this.meals;
  }
}
