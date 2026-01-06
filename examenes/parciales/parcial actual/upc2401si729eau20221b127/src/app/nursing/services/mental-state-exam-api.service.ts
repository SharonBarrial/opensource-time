/**
 * This file defines the mental state exam api service to obtain data from the json-server api.
 * @summary Mental State Exam Api Service
 * @author Salvador Antonio Salinas Torres
 */

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BaseApiService } from "../../shared/services/base-api.service";
import {MentalStateExam} from "../models/mental-state-exam.model";

@Injectable({
  providedIn: 'root'
})
export class MentalStateExamApiService extends BaseApiService<MentalStateExam> {

  constructor(http: HttpClient) {
    super(http);
    this.endpoint = 'mental-state-exams';
  }

  /*
  getAllExams() {
    return this.http.get(`${this.baseUrl}/mental-state-exams`);
  }

  getPatientById(id: number) {
    return this.http.get(`${this.baseUrl}/patients/${id}`);
  }

  getExaminerById(id: number) {
    return this.http.get(`${this.baseUrl}/examiners/${id}`);
  }
  */
}
