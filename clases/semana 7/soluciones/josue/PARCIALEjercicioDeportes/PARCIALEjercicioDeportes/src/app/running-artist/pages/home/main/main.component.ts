import { Component, OnInit } from '@angular/core';
import { OffersApiServiceService } from "../../../services/offers-api.service.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'] // Utiliza styleUrls en lugar de styleUrl
})
export class MainComponent implements OnInit {
  totalOffers: number = 0; // Variable para almacenar el total de ofertas

  constructor(private offersApi: OffersApiServiceService) {}

  ngOnInit() {
    console.log('hola')
    this.offersApi.getTotalNumberOfOffers().subscribe(
      total => {
        this.totalOffers = total; // Asigna el total de ofertas a la variable
        console.log(this.totalOffers)
      },
      error => {
        console.error('Error al obtener el total de ofertas:', error);
      }
    );
  }
}
