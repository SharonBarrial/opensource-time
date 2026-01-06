import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./public/pages/home/home.component";
import {AboutComponent} from "./public/pages/about/about.component";
import {PageNotFoundComponent} from "./public/pages/page-not-found/page-not-found.component";
import {OffersTabularViewComponent} from "./running-artist/pages/offers-tabular-view/offers-tabular-view.component";
import {MainComponent} from "./running-artist/pages/home/main/main.component";
import {AddOfferComponent} from "./running-artist/pages/add-offer/add-offer.component";
import {EditOfferComponent} from "./running-artist/pages/edit-offer/edit-offer.component";

const routes: Routes = [
  { path: 'home', component: MainComponent },
  { path: 'about', component: AboutComponent },
  { path: 'business/offers', component: OffersTabularViewComponent },
  { path: 'business/offers/new', component: AddOfferComponent },
  { path: 'business/offers/edit/:id', component: EditOfferComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
