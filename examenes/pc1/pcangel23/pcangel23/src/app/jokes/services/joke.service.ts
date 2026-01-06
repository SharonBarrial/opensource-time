import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class JokeService {
  baseUrl: string=environment.baseUrl;
  constructor(private http: HttpClient) { }

  getAllJokesCategories(){
    return this.http.get(this.baseUrl+'categories');
  }

  getJokeRandomCategory(category:string){
    return this.http.get(this.baseUrl+`random?category=${category}`);
  }
}
