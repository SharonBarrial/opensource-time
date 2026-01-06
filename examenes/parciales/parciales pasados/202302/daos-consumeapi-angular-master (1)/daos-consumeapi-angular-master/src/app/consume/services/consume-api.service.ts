import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Article } from '../model/article.entity';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConsumeApiService {

  //apiKey = "fecf4feeffa64e4da682e7d268612ce5";
  base_Url = "http://localhost:3001/students";
  constructor(private http: HttpClient) { }

  getSources() {
    return this.http.get(`http://localhost:3001/api/v1/participants`);
  }


  getRank1(){
    return this .http.get(`http://localhost:3001/participants?ranking=1`)
  }

 
}
