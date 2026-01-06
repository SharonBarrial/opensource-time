/**
 * This file defines the patients api service to obtain data from the json-server api.
 * @summary Patients Api Service
 * @author Salvador Antonio Salinas Torres
 */

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BaseApiService } from "../../shared/services/base-api.service";
import { Patient } from "../models/patient.model";

@Injectable({
  providedIn: 'root'
})
export class PatientsApiService extends BaseApiService<Patient> {

  constructor(http: HttpClient) {
    super(http);
    this.endpoint = 'patients';
  }

}
