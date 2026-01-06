import { Component } from '@angular/core';
import {AddFormComponent} from "../../components/add-form/add-form.component";

@Component({
  selector: 'app-new-offer',
  standalone: true,
  imports: [
    AddFormComponent
  ],
  templateUrl: './new-offer.component.html',
  styleUrl: './new-offer.component.css'
})
export class NewOfferComponent {

}
