import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from './../../app.constants';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http: HttpClient) { }

  createUser(user) {
    return this.http.post<any>(
              `${API_URL}/userRegistration`
                , user);
  }
}
