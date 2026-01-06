import { Routes } from '@angular/router';
import {HomeComponent} from "./public/components/home/home.component";
import {MoviesComponent} from "./movies/components/movies/movies.component";

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'business/peliculas', component: MoviesComponent},
  { path: '**', redirectTo: 'not-found' }
];
