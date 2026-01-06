import { Component } from '@angular/core';
import { Offer } from "../../models/offer.entity";
import { OffersApiServiceService } from "../../services/offers-api.service.service";
import { ActivatedRoute, Router } from "@angular/router";
import { MatSnackBar } from "@angular/material/snack-bar";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-add-offer',
  templateUrl: './add-offer.component.html',
  styleUrls: ['./add-offer.component.css']
})
export class AddOfferComponent {
  myForm: FormGroup = new FormGroup({
    title: new FormControl('', [
      Validators.required,
      Validators.maxLength(60)
    ]),
    description: new FormControl('', [
      Validators.required,
      Validators.maxLength(120)
    ]),
    points: new FormControl('', [
      Validators.required,
      Validators.max(100),
      Validators.min(0)
    ]),
    userId: new FormControl('', [
      Validators.required,
    ])
  });
  offerToCreate: Offer;
  idUrl: string | undefined;

  constructor(private offerService: OffersApiServiceService, private router: Router, private snackBar: MatSnackBar) {
    this.offerToCreate = {} as Offer;
  }

  createOffer() {
    if (this.myForm.valid) {

    this.offerService.create(this.offerToCreate).subscribe(
      (response: any) => {
        if (response) {
          // La oferta se creó correctamente
          this.showSuccessMessage('Offer created successfully');
          setTimeout(() => {
            // Acción que deseas ejecutar
            this.router.navigate(["/home"], { queryParams: { id: this.idUrl } });
          }, 1000);
          // Puedes realizar cualquier otra acción necesaria, como redireccionar
        } else {
          // Error en la creación de la oferta
          this.showErrorMessage('Failed to create offer. Please try again later.');
        }
      },
      (error: any) => {
        // Error en la solicitud
        this.showErrorMessage('An error occurred while creating the offer. Please try again later.');
        console.error('Error creating offer:', error);
      }
    );

  } else {
      this.showErrorMessage('Please complete all required fields');
}


  }

  showSuccessMessage(message: string): void {
    this.snackBar.open(message, 'Close', {
      duration: 3000,
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: ['success-snackbar']
    });
  }

  showErrorMessage(message: string): void {
    this.snackBar.open(message, 'Close', {
      duration: 5000,
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: ['error-snackbar']
    });
  }

  cancelEdit() {
    this.router.navigate(["/home"], { queryParams: { id: this.idUrl } });
  }
}
