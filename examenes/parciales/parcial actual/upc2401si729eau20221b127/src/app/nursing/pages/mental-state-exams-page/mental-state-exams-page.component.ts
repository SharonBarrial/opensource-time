import { Component } from '@angular/core';
import {
    MentalStateExamsCardsComponent
} from "../../components/mental-state-exams-cards/mental-state-exams-cards.component";

@Component({
  selector: 'app-mental-state-exams-page',
  standalone: true,
    imports: [
        MentalStateExamsCardsComponent
    ],
  templateUrl: './mental-state-exams-page.component.html',
  styleUrl: './mental-state-exams-page.component.css'
})
export class MentalStateExamsPageComponent {

}
