export class Movies {
  id: number;
  name: string;
  image: string;
  duration: string;
  genre: string;

  constructor(id: number, name: string, image: string, duration: string, genre: string) {
    this.id = id;
    this.name = name;
    this.image = image;
    this.duration = duration;
    this.genre = genre;
  }
}
