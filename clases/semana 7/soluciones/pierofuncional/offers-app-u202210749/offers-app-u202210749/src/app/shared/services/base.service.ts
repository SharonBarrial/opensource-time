import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment.development";
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, retry, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BaseService<T> {

  basePath: string = `${environment.serverBasePath}`;
  endpoint: string = '';

  constructor(protected _http:HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  handleError(error: HttpErrorResponse){
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    }else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }

  endpointPath(){
    return `${this.basePath}/${this.endpoint}`;
  }

  getOne(id:number): Observable<T>{
    return this._http.get<T>(`${this.endpointPath()}/${id}`, this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  getAll(): Observable<any>{
    return this._http.get<T>(this.endpointPath(), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  post(item:any): Observable<any>{
    return this._http.post<T>(this.endpointPath(), JSON.stringify(item), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  put(id:any, item:any): Observable<T>{
    return this._http.put<T>(`${this.endpointPath()}/${id}`, JSON.stringify(item), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  delete(id:any): Observable<T>{
    return this._http.delete<T>(`${this.endpointPath()}/${id}`, this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  deleteAll(path: string) {
    return this._http.delete<T>(`${this.endpointPath()}/${path}`, this.httpOptions). pipe(retry(2), catchError(this.handleError));
  }

}
