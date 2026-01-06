import { Injectable } from '@angular/core';
import {BaseService} from "../../shared/services/base.service";
import {Movies} from "../models/movie.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MovieService extends BaseService <Movies>{

  constructor(http: HttpClient) {
    super(http);
    this.resourceEndpoint = 'movies';
  }

  checkIfExists(name: string) {
    return this._http.get<any>(`${this.resourcePath()}/?name=${name}`)
  }
}
