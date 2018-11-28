import { Component, OnInit } from '@angular/core';
import { PolicyService } from './../service/data/policy.service';
import { Router } from '@angular/router';
import { BasicAuthenticationService } from './../service/basic-authentication.service';

export class Policy {
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public premiumDate: Date,
    public premiumAmount: number
  ) {}
}

@Component({
  selector: 'app-list-policies',
  templateUrl: './list-policies.component.html',
  styleUrls: ['./list-policies.component.css']
})
export class ListPoliciesComponent implements OnInit {
  policies: Policy[];

  message: string;

  localUser: string;

  constructor(
    private policyService: PolicyService,
    private basicAuthenticationService: BasicAuthenticationService,
    private router: Router
  ) {}

  ngOnInit() {
    this.localUser = this.basicAuthenticationService.getAuthenticatedUser();
    this.refreshPolicies();
  }

  refreshPolicies() {
    console.log(this.localUser);
    this.policyService
      .retrieveAllPolicies(this.localUser)
      .subscribe(response => {
        console.log(response);
        this.policies = response;
      });
  }

  deletePolicy(id) {
    console.log(`delete policy ${id}`);
    this.policyService.deletePolicy(this.localUser, id)
    .subscribe(response => {
      console.log(response);
      this.message = `Delete of policy ${id} Successful!`;
      this.refreshPolicies();
    });
  }

  updatePolicy(id) {
    console.log(`update ${id}`);
    this.router.navigate(['policies', id]);
  }

  addPolicy() {
    this.router.navigate(['policies', -1]);
  }
}
// policies = [
//   new Policy(1, 'Policy 1', false, new Date(), 10000),
//  new Policy(2, 'Ploicy 2', false, new Date(), 20000),
//  new Policy(3, 'Policy 3', false, new Date(), 30000)
// {id : 1, description : },
// {id : 2, description : ''},
// {id : 3, description : 'Visit India'}
// ];
