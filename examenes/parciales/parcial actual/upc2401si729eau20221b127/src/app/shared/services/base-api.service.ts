/**
 * This file defines the base api service to obtain data from the json-server api.
 * @summary Base Api Service
 * @author Salvador Antonio Salinas Torres
 */

import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import { catchError, Observable, throwError, retry } from "rxjs";

import { environment } from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class BaseApiService<T> {

  basePath: string = `${environment.baseUrl}`;
  endpoint: string = '';
  constructor(protected _http: HttpClient) { }

  httpOptions = {
    headers: {
      'Content-Type': 'application/json'
    }
  };


  handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error(
        'An error occurred:',
        error.error.message
      );
    } else {
      console.error(
        `Backend returned code ${error.status}, `
        + `body was: ${error.error}`
      );
    }
    return throwError(
      'Something bad happened; please try again later.'
    );
  }

  resourcePath() {
    return `${this.basePath}/${this.endpoint}`;
  }

  getOne(id: number) : Observable<any> {
    return this._http.get(`${this.resourcePath()}/${id}`, this.httpOptions)
      .pipe(retry(2), catchError(this.handleError))
  }

  getAll() : Observable<any> {
    return this._http.get(this.resourcePath(), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError))
  }


}
