import { Component } from '@angular/core';
import {OfferTableComponent} from "../../components/offer-table/offer-table.component";
import {MatButtonModule} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-list-offers',
  standalone: true,
  imports: [
    OfferTableComponent,
    MatButtonModule,
    MatIcon,
    RouterLink
  ],
  templateUrl: './list-offers.component.html',
  styleUrl: './list-offers.component.css'
})
export class ListOffersComponent {

}
