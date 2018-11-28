import { Injectable } from '@angular/core';
import { BasicAuthenticationService } from './../basic-authentication.service';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterBasicAuthService implements HttpInterceptor {

  constructor(private basicAuthenticationService: BasicAuthenticationService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler) {
    // let username = 'in28minutes'
    // let password = 'dummy'
    // let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
    // tslint:disable-next-line:prefer-const
    let basicAuthHeaderString = this.basicAuthenticationService.getAuthenticatedToken();
    // tslint:disable-next-line:prefer-const
    let username = this.basicAuthenticationService.getAuthenticatedUser();

    if (basicAuthHeaderString && username) {
      request = request.clone({
        setHeaders : {
            Authorization : basicAuthHeaderString
          }
        });
    }
    return next.handle(request);
  }

}

