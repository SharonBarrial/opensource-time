import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Appointment} from "../../model/appointment.entity";
import {MatTableDataSource} from "@angular/material/table";
import {AppointmentsService} from "../../services/appointments.service";

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit, AfterViewInit {

  appointmentData: Appointment;
  dataSource: MatTableDataSource<any>;
  displayedColumns: string[] = ['id', 'studentCode', 'teacherCode', 'dateTime', 'subject', 'actions'];
  isEditMode = false;


  constructor(private appointmentsService: AppointmentsService) {
    this.appointmentData = {} as Appointment;
    this.dataSource = new MatTableDataSource<any>();
  }

  private getAllAppointments() {
    this.appointmentsService.getAll().subscribe((response: any) => {
      this.dataSource.data = response;
    });
  }

  private deleteAppointment(id: number) {

  }

  onEditItem(element: Appointment) {
    this.appointmentData = element;
    this.isEditMode = true;
  }
  onDeleteItem(element: Appointment) {
    this.deleteAppointment(element.id);
  }
  onCancelEdit() {
    this.isEditMode = false;
    this.getAllAppointments();
  }

  onAppointmentAdded(appointment: Appointment) {

  }
  onAppointmentUpdated(appointment: Appointment) {

  }

  ngAfterViewInit(): void {
  }

  ngOnInit(): void {
    this.getAllAppointments();
  }

}
