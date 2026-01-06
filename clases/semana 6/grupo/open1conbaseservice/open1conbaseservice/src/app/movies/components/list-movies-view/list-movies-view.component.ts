import {Component, OnInit, ViewChild} from '@angular/core';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatButton, MatIconButton, MatMiniFabButton} from "@angular/material/button";
import {
  MatCell, MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow,
  MatRow,
  MatTableModule,
  MatTableDataSource
} from "@angular/material/table";
import {MatIcon} from "@angular/material/icon";
import {MatPaginator} from "@angular/material/paginator";
import {MovieService} from "../../services/movie.service";
import {Router} from "@angular/router";
import {Movies} from "../../models/movie.model";
import {MatSort, Sort} from "@angular/material/sort";


@Component({
  selector: 'app-list-movies-view',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatButton,
    MatTableModule,
    MatColumnDef,
    MatHeaderCell,
    MatCell,
    MatIcon,
    MatPaginator,
    MatHeaderRow,
    MatRow,
    MatIconButton,
    MatMiniFabButton,
    ReactiveFormsModule,
    MatHeaderCellDef,
    MatCellDef
  ],
  templateUrl: './list-movies-view.component.html',
  styleUrl: './list-movies-view.component.css'
})
export class ListMoviesViewComponent implements OnInit{

  @ViewChild(MatPaginator, {static: true})
  paginator!: MatPaginator;

  @ViewChild(MatSort, {static: true})
  sort!: MatSort;

  movies: FormGroup;

  isEditMode= false;
  displayedColumns: string[] = ['id', 'name', 'image', 'duration','genre', 'actions'];
  dataSource = new MatTableDataSource<Movies>();

  constructor(private moviesService: MovieService, private router: Router) {
    this.movies = new FormGroup({
      id: new FormControl(0),
      name: new FormControl("", Validators.required),
      image: new FormControl(""),
      duration: new FormControl("", Validators.required),
      genre: new FormControl("", Validators.required),
    })
  }

  ngOnInit() {
    this.getMovies();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  announceSortChange(sortState: Sort){
    if (sortState.direction){
      console.log(`Sorted ${sortState.direction}ending`);
    }else{
      console.log('Sorting cleared');
    }
  }

  getMovies(){
    this.moviesService.getAll().subscribe((response:any) => {
      this.dataSource.data = response;
    });
  }

  onSubmit() {
    if (this.movies.valid) {
      console.log(this.movies.value);
      const movie:Movies = new Movies(
        0,
        this.movies.value.name,
        this.movies.value.image,
        this.movies.value.duration,
        this.movies.value.genre,
      );
      if (this.isEditMode){
        movie.id = this.movies.value.id;
        this.updateMovie(movie);
      }
      this.moviesService.checkIfExists(this.movies.value.name).subscribe(exist=>{
        console.log(exist);
        if (exist.length>0){
          console.log("esa marca y correo ya existen")
        } else {
          console.log(movie);
          this.registerMovie(movie)
        }
      });
    } else {
      console.log("Formulario inválido");
    }
  }

  registerMovie(movies: Movies) {
    this.moviesService.post(movies).subscribe(response => {
      console.log(response);
      this.getMovies();
      this.movies.reset();
    })
  }
  updateMovie(movies: Movies){
    this.moviesService.update(movies.id, movies).subscribe(response => {
      this.getMovies();
      this.movies.reset();
      this.isEditMode = false;
    })
  }

  cancelEdit() {
    this.movies.reset(); // Reinicia el formulario
  }

  editMovie(movie: Movies){
    this.isEditMode = true;
    this.movies.patchValue({
      id: movie.id,
      name: movie.name,
      image: movie.image,
      duration: movie.duration,
      genre: movie.genre
    });
  }

  deleteMovie(element: any){
    this.moviesService.delete(element.id).subscribe(() => {
      this.dataSource.data = this.dataSource.data.filter((o: any) => o.id !== element.id);
    });
    alert('Movie Deleted Successfully!');
  }


}
