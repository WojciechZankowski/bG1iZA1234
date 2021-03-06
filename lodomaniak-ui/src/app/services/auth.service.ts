import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators';

import { ApiService } from '../core/api.service';
import { Credentials } from '../model/credentials.model';
import { PrincipalService } from './principal.service';

export const AUTH_PATH: string = '/authenticate';

@Injectable()
export class AuthService {

  private readonly TOKEN_KEY: string = 'authenticationToken';

  constructor(private apiService: ApiService,
              private principal: PrincipalService) {
  }

  getToken(): string {
    return localStorage.getItem(this.TOKEN_KEY) || sessionStorage.getItem(this.TOKEN_KEY);
  }

  login(credentials: Credentials): Observable<any> {
    return this.apiService.post(AUTH_PATH, credentials)
      .pipe(map(response => this.authenticateSuccess(credentials, response)));
  }

  private authenticateSuccess(credentials: Credentials, response: any): string {
    const bearerToken = response.headers.get('Authorization');
    if (bearerToken && bearerToken.slice(0, 7) === 'Bearer ') {
      const jwt = bearerToken.slice(7, bearerToken.length);
      this.storeAuthenticationToken(jwt, credentials.rememberMe);
      return jwt;
    }
  }

  private storeAuthenticationToken(jwt: string, rememberMe: boolean) {
    if (rememberMe) {
      localStorage.setItem(this.TOKEN_KEY, jwt);
    } else {
      sessionStorage.setItem(this.TOKEN_KEY, jwt);
    }
  }

  logout(): void {
    localStorage.removeItem(this.TOKEN_KEY);
    sessionStorage.removeItem(this.TOKEN_KEY);
    this.principal.logout();
  }

}
