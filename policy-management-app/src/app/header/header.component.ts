import { Component, OnInit } from '@angular/core';
import { BasicAuthenticationService } from '../service/basic-authentication.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


  constructor(public basicAuthenticationService: BasicAuthenticationService,
  private router: Router) { }

  ngOnInit() {
  }

  navigateToWelcomePage() {
    this.router.navigate(['welcome', this.basicAuthenticationService.getAuthenticatedUser()]);
  }

}
