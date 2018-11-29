import { Component, OnInit } from '@angular/core';

import { UserRegistrationService } from './../service/data/user-registration.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  user: User;
  errorFlag = false;
  message: string;
  errorMessage: string;
  constructor( private userRegistrationService: UserRegistrationService) {}

  ngOnInit() {
    this.user = new User(-1, '', '', '', '', '', '1');
  }

  saveUser() {
    console.log(this.user);
    if (this.user.password !== this.user.confirmPassword) {
      this.errorFlag = true;
      this.message = '';
      this.errorMessage = 'Your password and confirmation password do not match';
      return;
    }
      this.userRegistrationService.createUser(this.user)
          .subscribe (
            data => {
              console.log(data);
              this.user = data;
              // tslint:disable-next-line:triple-equals
              if (this.user.id == -1 || this.user.id == 0) {
                  this.errorFlag = true;
                  this.message = '';
                  this.errorMessage = ' Not able to create user, contact support !!!';
              } else {
                this.errorFlag = false;
                this.message = `User ${this.user.userName} created successfully !!!`;
                this.user = new User(-1, '', '', '', '', '', '1');
              }
            }
          );
  }
}

export class User {
  constructor(
    public id: number,
    public userName: string,
    public name: string,
    public lastName: string,
    public password: string,
    public confirmPassword: string,
    public active: string
  ) {}
}
