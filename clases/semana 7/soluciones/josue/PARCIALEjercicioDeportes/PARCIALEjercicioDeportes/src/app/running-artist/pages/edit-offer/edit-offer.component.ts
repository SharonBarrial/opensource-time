import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Offer} from "../../models/offer.entity";
import {OffersApiServiceService} from "../../services/offers-api.service.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-edit-offer',
  templateUrl: './edit-offer.component.html',
  styleUrl: './edit-offer.component.css'
})
export class EditOfferComponent implements OnInit{
  offerId: string|undefined;

  myForm: FormGroup = new FormGroup({
    title: new FormControl('', [
      Validators.required,
      Validators.maxLength(60)
    ]),
    description: new FormControl('', [
      Validators.required,
      Validators.maxLength(120),

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

  constructor(private offerService: OffersApiServiceService, private router: Router, private snackBar: MatSnackBar,private route: ActivatedRoute) {
    this.offerToCreate = {} as Offer;
  }

  ngOnInit(): void {
    console.log('hola')
    const offerIdUrl = this.route.snapshot.params['id'];
    console.log('url',offerIdUrl)
    this.offerId = offerIdUrl;

    this.offerService.getOfferById(this.offerId).subscribe(
      (offer: Offer) => {

        this.offerToCreate = offer;
        console.log('Offer details:', this.offerToCreate);
      },
      (error: any) => {
        console.error('Error fetching offer details:', error);
      }
    );
  }


  createOffer() {
    if (this.myForm.valid) {

      this.offerService.update(this.offerToCreate.id,this.offerToCreate).subscribe(
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
