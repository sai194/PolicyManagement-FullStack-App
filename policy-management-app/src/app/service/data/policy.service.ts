import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Policy } from './../../list-policies/list-policies.component';
import { API_URL } from './../../app.constants';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {

  constructor(private http: HttpClient) { }

  retrieveAllPolicies(username) {
    return this.http.get<Policy[]>(`${API_URL}/users/${username}/policies`);
  }

  deletePolicy(username, id) {
    return this.http.delete(`${API_URL}/users/${username}/policies/${id}`);
  }

  retrievePolicy(username, id) {
    return this.http.get<Policy>(`${API_URL}/users/${username}/policies/${id}`);
  }

  updatePolicy(username, id, policy) {
    return this.http.put(
          `${API_URL}/users/${username}/policies/${id}`
                , policy);
  }

  createPolicy(username, policy) {
    return this.http.post(
              `${API_URL}/users/${username}/policies`
                , policy);
  }
}
