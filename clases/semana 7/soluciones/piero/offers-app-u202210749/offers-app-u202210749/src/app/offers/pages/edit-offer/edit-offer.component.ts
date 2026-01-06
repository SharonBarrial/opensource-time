import { Component } from '@angular/core';
import {EditFormComponent} from "../../components/edit-form/edit-form.component";

@Component({
  selector: 'app-edit-offer',
  standalone: true,
  imports: [
    EditFormComponent
  ],
  templateUrl: './edit-offer.component.html',
  styleUrl: './edit-offer.component.css'
})
export class EditOfferComponent {

}
