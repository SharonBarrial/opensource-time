import { Injectable } from '@angular/core';
import { environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CharacterService {
  baseUrl: string = environment.baseUrl;
  constructor(private http: HttpClient) { }

// Function to fetch characters from the API.
  getCharacters(){
    return this.http.get(`${this.baseUrl}character/`);
  }
}
