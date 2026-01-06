import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Meal} from "../models/meal.model";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class MealService {
  baseURL:string = environment.baseUrl;

  constructor(private http: HttpClient) {}

  getMealRandom(){
    return this.http.get<Meal>(`${this.baseURL}/random.php`);
  }

  getAllMealForFirstNameLetter(index:string){
    return this.http.get<Meal[]>(`${this.baseURL}/search.php?f=${index}`);
  }
}
