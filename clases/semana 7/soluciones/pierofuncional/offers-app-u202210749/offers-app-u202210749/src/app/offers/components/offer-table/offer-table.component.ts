import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource, MatTableModule} from "@angular/material/table";

import {MatButton} from "@angular/material/button";
import {MatPaginator} from "@angular/material/paginator";
import {OfferService} from "../../services/offer.service";
import {RouterLink} from "@angular/router";
import {Offer} from "../../models/offer.model";
import {MatSort, MatSortHeader} from "@angular/material/sort";

@Component({
  selector: 'app-offer-table',
  standalone: true,
  imports: [
    MatTableModule,
    MatButton,
    MatPaginator,
    RouterLink,
    MatSort,
    MatSortHeader
  ],
  templateUrl: './offer-table.component.html',
  styleUrl: './offer-table.component.css'
})
export class OfferTableComponent implements OnInit{
  @ViewChild(MatPaginator, {static: true}) paginator!: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort!: MatSort;

  dataSource = new MatTableDataSource();
  displayedColumns: string[] = ['id', 'title', 'description', 'points', 'businessId', 'actions'];

  constructor(private offerService: OfferService) {}

  ngOnInit() {
    this.getOffers();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  getOffers() {
    this.offerService.getAll().subscribe(response => {
      this.dataSource.data = response;
    });
  }

  deleteOffer(offer: Offer) {
    this.offerService.delete(offer.id).subscribe(response => {
      this.getOffers();
      alert('Offer eliminado con éxito');
    });
  }
}
