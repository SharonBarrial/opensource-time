import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Offer} from "../../models/offer.entity";
import {OffersApiServiceService} from "../../services/offers-api.service.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition} from "@angular/material/snack-bar";
import {Router} from "@angular/router";

@Component({
  selector: 'app-offers-tabular-view',
  templateUrl: './offers-tabular-view.component.html',
  styleUrl: './offers-tabular-view.component.css'
})
export class OffersTabularViewComponent implements OnInit, AfterViewInit  {
  dataSource!: MatTableDataSource<any>;//nota aca va la data que usaremos
  offersData: Offer;

  displayedColumns: string[] = ['id', 'title', 'description', 'points', 'businessId', 'actions'];
  @ViewChild(MatPaginator, {static: false}) paginator!: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort!: MatSort;
  isEditMode: boolean;

  constructor(private offersService:OffersApiServiceService, private snackBar: MatSnackBar,private router: Router) {
    this.dataSource = new MatTableDataSource<any>();
    this.offersData = {} as Offer;
    this.isEditMode = false;

  }


  onDeleteItem(element: Offer) {
    this.deleteOffer(element.id);
    console.log("METODO ondelete ITEM")
  }

  private deleteOffer(studentId: number) {
    this.offersService.delete(studentId).subscribe(() => {
      this.dataSource.data = this.dataSource.data.filter((student: Offer) => {
        if (student.id !== studentId) {
          return true; // Mantén este estudiante en la lista
        } else {
          this.showDeleteSuccessMessage(); // Muestra la alerta de eliminación exitosa
          return false; // Elimina este estudiante de la lista
        }
      });
    });
  };
  private showDeleteSuccessMessage(): void {
    const config = {
      duration: 3000,
      verticalPosition: 'top' as MatSnackBarVerticalPosition // Ajustar la posición vertical a 'top'
    };

    this.snackBar.open('User successfully deleted', 'Close', config);
  }

  private gettAllOffers(){
    this.offersService.getAll().subscribe((offersResponse: any) => {
      this.dataSource.data = offersResponse
      console.log(this.dataSource.data)
    });
  }


  ngOnInit(): void {
    this.gettAllOffers()

  }
  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  addNewOffer() {
    this.router.navigate(["/business/offers/new"], );
  }
  seeIdPublication(id:number) {
    console.log(id)
    this.router.navigate([`business/offers//edit/`+id],);
  }
}

