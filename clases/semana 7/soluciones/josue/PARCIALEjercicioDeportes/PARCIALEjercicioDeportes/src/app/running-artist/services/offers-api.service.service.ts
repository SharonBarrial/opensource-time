import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { BaseService } from "../../shared/services/base.service";
import { Offer } from "../models/offer.entity";
import {catchError, Observable, retry} from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OffersApiServiceService extends BaseService<Offer> {

  constructor(http: HttpClient) {
    super(http);
    this.resourceEndpoint = '/offers';
  }

  // Método para obtener el número total de ofertas disponibles
  getTotalNumberOfOffers(): Observable<number> {
    return this.getAll().pipe(
      // Utilizamos el operador map para transformar el array de ofertas en su longitud
      map(offers => {
        if (Array.isArray(offers)) {
          return offers.length;
        } else {
          return 0; // Si no es un array, devolvemos 0
        }
      })
    );
  }

  getOfferById(id: string | undefined): Observable<Offer> {
    return this.http.get<Offer>(`${this.basePath}${this.resourceEndpoint}/${id}`, this.httpOptions)
      .pipe(
        retry(2), // Intenta la solicitud dos veces en caso de error
        catchError(this.handleError) // Maneja los errores
      );
  }


}
