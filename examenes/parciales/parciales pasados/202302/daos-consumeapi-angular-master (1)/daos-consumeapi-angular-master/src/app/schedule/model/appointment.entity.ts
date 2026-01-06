export class Appointment {
  id: number;
  studentCode: string;
  teacherCode: number;
  dateTime: string;
  subject: string;
  constructor() {
    this.id = 0;
    this.studentCode = '';
    this.teacherCode = 0;
    this.dateTime = '';
    this.subject = '';
  }
}
