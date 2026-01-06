import { Routes } from '@angular/router';
import { HomeContentComponent } from "./public/pages/home-content/home-content.component";
import { PageNotFoundComponent } from "./public/pages/page-not-found/page-not-found.component";
import { MentalStateExamsPageComponent } from "./nursing/pages/mental-state-exams-page/mental-state-exams-page.component";

export const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeContentComponent},
  {path: 'nursing/mental-state-exams', component: MentalStateExamsPageComponent},
  {path: '**', component: PageNotFoundComponent}
];
