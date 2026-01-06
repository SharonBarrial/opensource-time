import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {MatInputModule} from "@angular/material/input";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";
import {MatSortModule} from "@angular/material/sort";
import {MatIconModule} from "@angular/material/icon";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatCardModule} from "@angular/material/card";
import {MatGridListModule} from "@angular/material/grid-list";
import { HomeComponent } from './public/pages/home/home.component';
import { AboutComponent } from './public/pages/about/about.component';
import { PageNotFoundComponent } from './public/pages/page-not-found/page-not-found.component';
import { ToolbarComponent } from './public/components/toolbar/toolbar.component';
import { MainComponent } from './running-artist/pages/home/main/main.component';
import { OffersTabularViewComponent } from './running-artist/pages/offers-tabular-view/offers-tabular-view.component';
import { FooterComponentComponent } from './public/components/footer-component/footer-component.component';
import {OfferManmagerComponent} from "./running-artist/components/offer-manmager/offer-manmager.component";
import { AddOfferComponent } from './running-artist/pages/add-offer/add-offer.component';
import {MatTab} from "@angular/material/tabs";
import {MatRipple} from "@angular/material/core";
import { EditOfferComponent } from './running-artist/pages/edit-offer/edit-offer.component';
import { HomeViewComponent } from './running-artist/pages/home-view/home-view.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    PageNotFoundComponent,
    ToolbarComponent,
    MainComponent,
    OffersTabularViewComponent,
    OffersTabularViewComponent,
    FooterComponentComponent,
    OfferManmagerComponent,
    AddOfferComponent,
    EditOfferComponent,
    HomeViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatTableModule,
    MatSortModule,
    MatIconModule,
    MatPaginatorModule,
    MatToolbarModule,
    MatCardModule,
    MatGridListModule,
    MatTab,
    MatRipple
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
