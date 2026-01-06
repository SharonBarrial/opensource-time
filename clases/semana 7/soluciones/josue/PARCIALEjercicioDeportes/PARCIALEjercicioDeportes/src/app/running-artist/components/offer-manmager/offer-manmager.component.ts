import {Component, EventEmitter, Input, Output, ViewChild} from '@angular/core';
import {Offer} from "../../models/offer.entity";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-offer-manmager',
  templateUrl: './offer-manmager.component.html',
  styleUrl: './offer-manmager.component.css'
})
export class OfferManmagerComponent {
  @Input() offer: Offer;
  @Input() editMode = false;
  @Output() offerAdded = new EventEmitter<Offer>();
  @Output() offerUpdated = new EventEmitter<Offer>();
  @Output() editCanceled = new EventEmitter();
  @ViewChild('studentForm', {static: false}) offerForm!: NgForm;
  constructor() {
    this.offer={} as Offer;}

  onSubmit() {
    if (this.offerForm.form.valid) {
      let emitter = this.editMode ? this.offerUpdated : this.offerAdded;
      emitter.emit(this.offer);
      this.resetEditState();
    } else {
      console.error('Invalid data in form');
    }
  }

  onCancel() {
    this.editCanceled.emit();
    this.resetEditState();
  }
  private resetEditState() {
    this.offer = {} as Offer;
    this.editMode = false;
    this.offerForm.resetForm();
  }
}

