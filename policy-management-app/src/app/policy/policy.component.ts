import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Policy } from './../list-policies/list-policies.component';
import { PolicyService } from './../service/data/policy.service';
import { BasicAuthenticationService } from './../service/basic-authentication.service';


@Component({
  selector: 'app-policy',
  templateUrl: './policy.component.html',
  styleUrls: ['./policy.component.css']
})
export class PolicyComponent implements OnInit {
  id: number;
  policy: Policy;
  localUser: string;
  constructor(private policyService: PolicyService,
    private basicAuthenticationService: BasicAuthenticationService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.localUser = this.basicAuthenticationService.getAuthenticatedUser();
    this.policy = new Policy(this.id, '', false, new Date(), null);
    // tslint:disable-next-line:triple-equals
    if (this.id != -1) {
    this.policyService.retrievePolicy(this.localUser, this.id)
        .subscribe (
          data => this.policy = data
        );
      }
  }


  savePolicy() {
    console.log(this.policy);
    // tslint:disable-next-line:triple-equals
    if (this.id == -1) {
      console.log('new policy');
      this.policyService.createPolicy(this.localUser, this.policy)
          .subscribe (
            data => {
              console.log(data);
              this.router.navigate(['policies']);
            }
          );
    } else {
      console.log('existing policy');
      this.policyService.updatePolicy(this.localUser, this.id, this.policy)
          .subscribe (
            data => {
              console.log(data);
              this.router.navigate(['policies']);
            }
          );
    }
  }

}
