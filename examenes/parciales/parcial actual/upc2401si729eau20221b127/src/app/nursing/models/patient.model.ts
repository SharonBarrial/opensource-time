export class Patient {
    id: number;
    firstName: string;
    lastName: string;
    birthDate: string;
    photoUrl: string
    constructor(id: number, firstName: string, lastName: string, birthDate: string, photoUrl: string) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.photoUrl = photoUrl;
    }
}
