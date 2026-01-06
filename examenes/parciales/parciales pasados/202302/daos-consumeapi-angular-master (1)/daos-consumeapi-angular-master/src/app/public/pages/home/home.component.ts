import { Component, OnInit } from '@angular/core';
import { ConsumeApiService } from 'src/app/consume/services/consume-api.service';
import { Task } from 'src/app/schedule/model/rank.module';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 
  tasks: Task[] = [];

  newTask: Task = {
    id :0,
    firstName:'',
    lastName:'',
    photoUrl:'' ,
    centerId:'',
    ranking:'',
    recordTime:'' ,
  };

  constructor(private consumeService: ConsumeApiService) { }

private getAllSources(): void {
  this.consumeService.getRank1().subscribe(
    (res: any) => {
      console.log(res); // PORQUE NO SALE AAA 
      this.tasks = res;
    },
    (error) => {
      console.error(error);
    }
  );
  };



  ngOnInit(): void {
    this.getAllSources();
  }
  
}
