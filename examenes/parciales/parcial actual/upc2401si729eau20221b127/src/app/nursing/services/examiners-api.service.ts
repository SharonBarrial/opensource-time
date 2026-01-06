/**
 * This file defines the examiners api service to obtain data from the json-server api.
 * @summary Examiners Api Service
 * @author Salvador Antonio Salinas Torres
 */

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { BaseApiService } from "../../shared/services/base-api.service";
import {Examiner} from "../models/examiner.model";

@Injectable({
  providedIn: 'root'
})
export class ExaminersApiService extends BaseApiService<Examiner> {

  constructor(http: HttpClient) {
    super(http);
    this.endpoint = 'examiners';
  }
}
