import { Component } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  title = 'Consume API';

  options = [
    { path: '/home', title: 'Home'},
    { path: '/consume', title: 'News Api'},
    { path: '/schedule/appointment', title: 'Appointment'},
    { path: '/about', title: 'About'},

  ]
}
