import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableModule, MatTableDataSource} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {FormsModule, NgForm} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {FakeApiService} from "../../services/fake-api.service";
import {Movie} from "../../models/movie.model";
import {cloneDeep} from "lodash";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort, Sort, MatSortModule} from "@angular/material/sort";

@Component({
  selector: 'app-movies',
  standalone: true,
  imports: [
    MatTableModule,
    MatButtonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatPaginator,
    MatSortModule,
  ],
  templateUrl: './movies.component.html',
  styleUrl: './movies.component.css'
})
export class MoviesComponent implements OnInit{
  //Referencia al formulario en la plantilla para manejar el formulario de peliculas
  @ViewChild('movieForm', {static: false})
  movieForm!: NgForm;
  @ViewChild(MatPaginator, {static: true})
  paginator!: MatPaginator;
  @ViewChild(MatSort, {static: true})
  sort!: MatSort;
  //Datos de la pelicula para el formulario
  movieData!: Movie;

  dataSource = new MatTableDataSource();
  displayedColumns: string[] = ['id', 'name', 'image', 'duration', 'genre', 'actions'];

  isEditMode = false;

  constructor(private fakeApiService: FakeApiService) {
    this.movieData = {} as Movie;
  }

  ngOnInit() {
    this.getMovies();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  announceSortChange(sortState: Sort) {
    if (sortState.direction) {
      console.log(`Sorted ${sortState.direction}ending`);
    } else {
      console.log ('Sorting cleared');
    }
  }

  getMovies() {
    this.fakeApiService.getList().subscribe((response: any) => {
      this.dataSource.data = response;
    });
  }

  editMovie(element: any) {
    this.movieData = cloneDeep(element);
    this.isEditMode = true;
  }

  cancelEdit() {
    this.isEditMode = false;
    this.movieForm.resetForm();
  }

  deleteMovie(element: any) {
    this.fakeApiService.deleteItem(element.id).subscribe(() => {
      this.dataSource.data = this.dataSource.data.filter((o: any) => o.id !== element.id);
    });
    alert('Película eliminado con éxito!');
  }

  updateMovie() {
    this.fakeApiService.updateItem(this.movieData)
      .subscribe((response:any) => {
        this.dataSource.data = this.dataSource.data.map((o: any) => {
          if (o.id === response.id) {
            o = response;
          }
          return o;
        });
        this.cancelEdit();
      });
  }

  createMovie() {
    let maxID: number = 0;
    maxID = this.dataSource.data
      .reduce((max: number, movie:any) => movie.id > max ? movie.id : max, 0);
    this.movieData.id = (Number(maxID) + 1).toString();

    this.fakeApiService.createItem(this.movieData)
      .subscribe((response: any) => {
        this.dataSource.data.push({...response});
        this.dataSource.data = this.dataSource.data.map(o => o);
      });
  }

  onSubmit() {
    if (this.movieForm.form.valid) {
      // Check if we need to edit or create a movie
      if (this.isEditMode) {
        this.updateMovie();
      } else {
        this.createMovie();
      }
    } else {
      console.log('Invalid Data');
    }
  }

}
