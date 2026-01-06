import {Component, OnInit} from '@angular/core';
import {JokesCardComponent} from "../jokes-card/jokes-card.component";
import {JokeService} from "../../services/joke.service";
import {JokeModel} from "../../model/joke.model";

@Component({
  selector: 'app-grid-jokes-cards',
  standalone: true,
  imports: [
    JokesCardComponent
  ],
  templateUrl: './grid-jokes-cards.component.html',
  styleUrl: './grid-jokes-cards.component.css'
})
export class GridJokesCardsComponent implements OnInit {
  categories: string[]=[];
  ngOnInit() {
    this.getCategoriesJokes()
  }
  constructor(private jokeService: JokeService) {
  }
  getCategoriesJokes(){
    this.jokeService.getAllJokesCategories().subscribe((data:any)=>{
      this.categories = data;
    })
  }
}
