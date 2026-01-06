export class Examiner {
  id: any;
  firstName: any;
  lastName: any;
  nationalProviderIdentifier: any;
  constructor(id: number, firstName: string, lastName: string, nationalProviderIdentifier: string) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.nationalProviderIdentifier = nationalProviderIdentifier;
  }
}
