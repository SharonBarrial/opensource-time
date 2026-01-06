import { Routes } from '@angular/router';
import { TheHomeContentComponent } from "./public/components/the-home-content/the-home-content.component";
import { ListMoviesViewComponent } from "./movies/components/list-movies-view/list-movies-view.component";
import { PageNotFoundComponent } from "./public/components/page-not-found/page-not-found.component";

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: TheHomeContentComponent },
  { path: 'business/peliculas', component: ListMoviesViewComponent },
  { path: '', pathMatch: 'full', redirectTo: 'home'},
  //toda ruta que no exista se redirige a home
  //{path: '**', pathMatch: 'full', redirectTo: 'home'}

  //toda ruta que no existe muestra la vista page not found
  { path: '**', component: PageNotFoundComponent }
];

