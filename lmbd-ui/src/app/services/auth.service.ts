import {Injectable} from "@angular/core";
import {ApiService} from "../core/api.service";
import {Credentials} from "../model/credentials.model";
import {Observable} from "rxjs/Observable";

export const AUTH_PATH: string = '/authenticate';

@Injectable()
export class AuthService {

  private readonly TOKEN_KEY: string = 'authenticationToken';

  constructor(private apiService: ApiService) {
  }

  getToken(): string {
    return localStorage.getItem(this.TOKEN_KEY) || sessionStorage.getItem(this.TOKEN_KEY);
  }

  login(credentials: Credentials): Observable<any> {
    return this.apiService.post(AUTH_PATH, credentials).map(response => this.authenticateSuccess(credentials, response));
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

}
