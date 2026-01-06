import {Component, Input, OnInit} from '@angular/core';
import {JokeService} from "../../services/joke.service";
import {JokeModel} from "../../model/joke.model";
import {MatCardModule} from '@angular/material/card';

@Component({
  selector: 'app-jokes-card',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './jokes-card.component.html',
  styleUrl: './jokes-card.component.css'
})
export class JokesCardComponent implements OnInit {
  @Input() category:string;
  joke?:JokeModel;

  constructor(private jokeService: JokeService) {
    this.category='';
  }

  ngOnInit(): void {
    this.getJokeRandom()
  }

  getJokeRandom(){
    this.jokeService.getJokeRandomCategory(this.category).subscribe((data:any)=>{
      this.joke = new JokeModel(data.id, data.value, data.categories);
      console.log(this.joke);
    })
  }
}
