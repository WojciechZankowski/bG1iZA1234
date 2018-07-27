import { ApiService } from "../core/api.service";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import { map } from "rxjs/operators";
import { FacebookLogin } from "../model/facebook-login.model";
import { Storage } from '@ionic/storage';

export const AUTH_PATH: string = '/authenticate/social/facebook';

@Injectable()
export class AuthService {

  private readonly TOKEN_KEY: string = 'authenticationToken';

  constructor(private apiService: ApiService,
              private storage: Storage) {
  }

  login(login: FacebookLogin): Observable<any> {
    return this.apiService.post(AUTH_PATH, login)
      .pipe(map(response => this.authenticateSuccess(response)));
  }

  private authenticateSuccess(response: any): string {
    const bearerToken = response.headers.get('Authorization');
    if (bearerToken && bearerToken.slice(0, 7) === 'Bearer ') {
      const jwt = bearerToken.slice(7, bearerToken.length);
      this.storeAuthenticationToken(jwt);
      return jwt;
    }
  }

  private storeAuthenticationToken(jwt: string) {
    this.storage.set(this.TOKEN_KEY, jwt);
  }

  logout(): void {
    this.storage.remove(this.TOKEN_KEY);
  }

}
