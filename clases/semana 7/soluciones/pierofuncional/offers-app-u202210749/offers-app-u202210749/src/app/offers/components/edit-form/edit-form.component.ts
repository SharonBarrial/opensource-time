import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {FormsModule, FormControl, FormGroup, NgForm, ReactiveFormsModule,Validators} from "@angular/forms";
import { MatFormFieldModule } from "@angular/material/form-field";
import {MatButton} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {Offer} from "../../models/offer.model";
import {OfferService} from "../../services/offer.service";

@Component({
  selector: 'app-edit-form',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatButton,
    FormsModule,
    RouterLink
  ],
  templateUrl: './edit-form.component.html',
  styleUrl: './edit-form.component.css'
})
export class EditFormComponent implements OnInit{
  offerForm: FormGroup = new FormGroup({
    id: new FormControl(0),
    title: new FormControl('', [Validators.required, Validators.maxLength(60)]),
    description: new FormControl(''),
    points: new FormControl(0, [Validators.required, Validators.max(100)]),
    businessId: new FormControl(0),
  });

  constructor(private offersService: OfferService, private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    let id = +this.activatedRoute.snapshot.paramMap.get('id')!; //not null and number
    this.offersService.getOne(id).subscribe((data) => {
      const offer: Offer = {
        id: data.id,
        title: data.title,
        description: data.description,
        points: data.points,
        businessId: data.businessId
      };
      this.offerForm.patchValue(offer);
    });

    this.offerForm.get('id')?.disable(); //id cant be changed
  }

  onSubmit() {
    if (this.offerForm.valid) {
      const offer: Offer = {
        id: this.offerForm.get('id')?.value,
        title: this.offerForm.get('title')?.value,
        description: this.offerForm.get('description')?.value ?? "",
        points: this.offerForm.get('points')?.value,
        businessId: this.offerForm.get('businessId')?.value ?? 0
      };

      this.offersService.put(offer.id, offer).subscribe(response => {
        console.log(response);
        this.router.navigate(['/offers']);
      }, error => {
        console.error(error);
        alert('Failed to update offer. Please try again later.');
      });
    } else {
      alert('Invalid form');
    }
  }

}
