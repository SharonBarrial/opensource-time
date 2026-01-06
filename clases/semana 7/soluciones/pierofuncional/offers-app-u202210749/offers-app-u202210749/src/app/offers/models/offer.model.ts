export class Offer {
  id: number;
  title: string;
  description: string;
  points: number;
  businessId: number;

  constructor(id: number, title: string, description: string, points: number, businessId: number) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.points = points;
    this.businessId = businessId;
  }
}
