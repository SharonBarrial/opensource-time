import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {catchError, Observable, retry, throwError} from "rxjs";
import { Movie } from '../models/movie.model';

@Injectable({
  providedIn: 'root'
})

export class FakeApiService {
  base_URL = environment.baseURL;

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: {
      'Content-Type': 'application/json'
    }
  }

  handleError(error: HttpErrorResponse){
    if(error.error instanceof ErrorEvent){
      //Manejo de errores del cliente o de red
      console.error('An error occurred:', error.error.message);
    }
    else {
      //Errores del backend
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    //Devuelven un Observable con un mensaje de error
    return throwError(
      'Something bad happened; please try again later.');
  }

  getList(): Observable<Movie[]>{
    return this.http
      .get<Movie[]>(this.base_URL)
      .pipe(retry(2), catchError(this.handleError));
  }

  createItem(item: any): Observable<Movie>{
    return this.http
      .post<Movie>(this.base_URL, JSON.stringify(item), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  getItem(id:string){
    return this.http
      .get<Movie>(`${this.base_URL}/${id}`)
      .pipe(retry(2), catchError(this.handleError));
  }

  updateItem(item: any): Observable<Movie>{
    return this.http
      .put<Movie>(`${this.base_URL}/${item.id}`, JSON.stringify(item), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  deleteItem(id:string): Observable<Movie>{
    return this.http
      .delete<Movie>(`${this.base_URL}/${id}`, this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }



}
