export class Offer {
  id: number;
  title: string;
  description: string;
  points: number;
  businessId: number;
  imageUrl: string;

  constructor() {
    this.id = 1;
    this.title = '';
    this.description = '';
    this.points = 2;
    this.businessId = 2;
    this.imageUrl = '';
  }
}
