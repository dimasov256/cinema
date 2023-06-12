import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isAuthenticated = false;

  constructor() {
  }

  ngOnInit(): void {
    // add authentication on start
  }

  login(): void {
    this.isAuthenticated = true;
    console.log('Login: ', this.isAuthenticated);
    // add authorization logic
    // TODO: add aoth0 authentication
  }

  logOut(): void {
    // logoff logic
    console.log('Logout: ', this.isAuthenticated);
    // TODO: add aoth0 authentication

  }
}
