import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RouteGaurdService } from './service/route-guard.service';
import { ListPoliciesComponent } from './list-policies/list-policies.component';
import { LogoutComponent } from './logout/logout.component';
import { ErrorComponent } from './error/error.component';
import { PolicyComponent } from './policy/policy.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';

const routes: Routes = [
  { path: '', component: LoginComponent,  },
  { path: 'login', component: LoginComponent },
  { path: 'welcome/:name', component: WelcomeComponent, canActivate: [RouteGaurdService] },
  { path: 'policies', component: ListPoliciesComponent, canActivate: [RouteGaurdService]  },
  { path: 'logout', component: LogoutComponent },
  { path: 'policies/:id', component: PolicyComponent, canActivate: [RouteGaurdService] },
  { path: 'userRegistration', component: UserRegistrationComponent },

  { path: '**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
