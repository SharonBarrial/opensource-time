import {Component, EventEmitter, Input, Output, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Appointment} from "../../model/appointment.entity";

@Component({
  selector: 'app-appointment-form',
  templateUrl: './appointment-form.component.html',
  styleUrls: ['./appointment-form.component.css']
})
export class AppointmentFormComponent {

  @Output()editCanceled = new EventEmitter();
  @Output()appointmentAdded = new EventEmitter<Appointment>();
  @Output()appointmentUpdated = new EventEmitter<Appointment>();
  @Input()editMode = false;
  @Input()appointment: Appointment;

  @ViewChild('appointmentForm', {static: false}) appointmentForm!: NgForm;

  constructor() {
    this.appointment = {} as Appointment;
  }

  onSubmit() {

  }
  onCancel() {

  }

}
