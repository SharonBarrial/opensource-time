/**
 * This file defines the component that shows the mental state exams cards.
 * @summary Mental State Exams Cards Component
 * @author Salvador Antonio Salinas Torres
 */

import { Component, OnInit } from '@angular/core';
import {MatCard, MatCardContent} from "@angular/material/card";
import {MentalStateExam} from "../../models/mental-state-exam.model";
import {MentalStateExamApiService} from "../../services/mental-state-exam-api.service";
import {PatientsApiService} from "../../services/patients-api.service";
import {ExaminersApiService} from "../../services/examiners-api.service";
import {Examiner} from "../../models/examiner.model";

@Component({
  selector: 'app-mental-state-exams-cards',
  standalone: true,
    imports: [
        MatCard,
        MatCardContent
    ],
  templateUrl: './mental-state-exams-cards.component.html',
  styleUrl: './mental-state-exams-cards.component.css'
})
export class MentalStateExamsCardsComponent implements OnInit {
  exams: MentalStateExam[] = [];
  examData: any;

  constructor(private mentalStateExamApiService: MentalStateExamApiService,
              private patientsApiService: PatientsApiService,
              private examinersApiService: ExaminersApiService) { }

  ngOnInit() {
    this.getMentalStateExams()
  }

  getMentalStateExams() {
    this.mentalStateExamApiService.getAll()
      .subscribe((res: any) => {
        res.forEach((exam: any) => {
          this.patientsApiService.getOne(exam.patientId).subscribe((patient: any) => {
            this.examinersApiService.getOne(exam.examinerId).subscribe((examiner: any) => {
                this.examData = new MentalStateExam(
                  exam.id,
                  exam.patientId,
                  exam.examinerId,
                  exam.examDate,
                  patient.photoUrl,
                  patient.firstName + ' ' + patient.lastName,
                  patient.birthDate,
                  examiner.firstName + ' ' + examiner.lastName,
                  examiner.nationalProviderIdentifier,
                  parseInt(exam.orientationScore) + parseInt(exam.registrationScore) + parseInt(exam.attentionAndCalculationScore) + parseInt(exam.recallScore) + parseInt(exam.languageScore)
                );
                this.exams.push(this.examData)
              }
            )
          })
        });
      });
  }


}
