import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {FormsModule, FormControl, FormGroup, NgForm, ReactiveFormsModule,Validators} from "@angular/forms";
import { MatFormFieldModule } from "@angular/material/form-field";
import {MatButton} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {Offer} from "../../models/offer.model";
import {OfferService} from "../../services/offer.service";

@Component({
  selector: 'app-add-form',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatButton,
    FormsModule,
    RouterLink
  ],
  templateUrl: './add-form.component.html',
  styleUrl: './add-form.component.css'
})
export class AddFormComponent {
  offerForm: FormGroup = new FormGroup({
    title: new FormControl('', [Validators.required, Validators.maxLength(60)]),
    description: new FormControl(),
    points: new FormControl( null, [Validators.required, Validators.max(100)]),
    businessId: new FormControl(),
  });

  constructor(private offersService: OfferService, private router: Router) {}


  onSubmit() {
    if(this.offerForm.valid) {
      const offer: Offer = {
        id: 0,
        title: this.offerForm.get('title')?.value,
        description: this.offerForm.get('description')?.value,
        points: this.offerForm.get('points')?.value,
        businessId: this.offerForm.get('businessId')?.value
      };

      this.offersService.create(offer).subscribe(response => {
        console.log(response);
        this.router.navigate(['/offers']);
      }, error => {
        console.error(error);
        alert('Failed to add offer. Please try again later.');
      });
    }
  }
}
