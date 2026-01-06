import { Routes } from '@angular/router';
import {NewOfferComponent} from "./offers/pages/new-offer/new-offer.component";
import {HomeComponent} from "./public/pages/home/home.component";
import {ListOffersComponent} from "./offers/pages/list-offers/list-offers.component";
import {EditOfferComponent} from "./offers/pages/edit-offer/edit-offer.component";
import {PageNotFoundComponent} from "./public/pages/page-not-found/page-not-found.component";

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'offers', redirectTo: 'business/offers', pathMatch: 'full' },
  { path: 'business/offers', component: ListOffersComponent },
  { path: 'admin/offers/new', component: NewOfferComponent },
  { path: 'admin/offers/edit/:id', component: EditOfferComponent },
  { path: '**', component: PageNotFoundComponent }
];


