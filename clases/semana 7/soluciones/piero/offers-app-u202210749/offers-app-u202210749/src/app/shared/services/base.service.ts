import {environment} from "../../../environments/environment.development";
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, retry, throwError} from "rxjs";

export class BaseService<T> {
  basePath: string = `${environment.serverBasePath}`;
  endpoint: string = '/endpoint';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-type': 'application/json',
    })
  }

  constructor(private _http: HttpClient) {  }

  handleError(error: HttpErrorResponse) {
    // Default error handling
    if (error.error instanceof ErrorEvent) {
      console.log(`An error occurred ${error.error.message}`);
    } else {
      // Unsuccessful Response Error Code returned from Backend
      console.log(`Backend returned code ${error.status}, body was ${error.error}`);
    }
    return throwError(() => new Error('Something happened with request, please try again later'));
  }

  create(item: any): Observable<T> {
    return this._http.post<T>(this.endpointPath(), JSON.stringify(item), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  delete(id: any) {
    return this._http.delete(`${this.endpointPath()}/${id}`, this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  update(id: any, item: any): Observable<T> {
    return this._http.put<T>(`${this.endpointPath()}/${id}`, JSON.stringify(item), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  getAll(): Observable<any> {
    return this._http.get<T>(this.endpointPath(), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  getOne(id: any): Observable<T> {
    return this._http.get<T>(`${this.endpointPath()}/${id}`, this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  private endpointPath(): string {
    return `${this.basePath}${this.endpoint}`;
  }
}
