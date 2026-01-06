import { Injectable } from '@angular/core';
import {BaseService} from "../../shared/services/base.service";
import {Offer} from "../models/offer.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class OfferService extends BaseService<Offer> {
  constructor(http: HttpClient) {
    super(http);
    this.endpoint = 'offers';
  }
}
