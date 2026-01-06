export class MentalStateExam {
  id: any;
  patientId: any;
  examinerId: any;
  examDate: any;
  photoUrl: any;
  patientName: any;
  bornDate: any;
  examinerName: any;
  nationalProviderIdentifier: any;
  totalScore: any;

  constructor(id = '', patientId= '', examinerId = '', examDate = '', photoUrl = '', patientName = '', bornDate = '', examinerName = '', nationalProviderIdentifier = '', totalScore = 0) {
    this.id = id;
    this.patientId = patientId;
    this.examinerId = examinerId;
    this.examDate = examDate;
    this.photoUrl = photoUrl;
    this.patientName = patientName;
    this.bornDate = bornDate;
    this.examinerName = examinerName;
    this.nationalProviderIdentifier = nationalProviderIdentifier;
    this.totalScore = totalScore;
  }

}
