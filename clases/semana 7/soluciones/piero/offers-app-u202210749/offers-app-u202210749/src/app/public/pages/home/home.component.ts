import {Component, OnInit} from '@angular/core';
import {OfferService} from "../../../offers/services/offer.service";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  count: number = 0;

  constructor(private offerService: OfferService) { }

  ngOnInit() {
    this.offerService.getAll().subscribe(response => {
      this.count = response.length;
    });
  }

}
