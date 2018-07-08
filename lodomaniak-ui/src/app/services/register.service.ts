import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";

import {ApiService} from "../core/api.service";
import {Account} from "../model/account.model";
import {HttpParams} from "@angular/common/http";
import {PasswordReset} from "../model/password-reset.model";

export const ACCOUNT_PATH = '/account';
export const REGISTER_PATH = '/register';
export const ACTIVATE_PATH = '/activate';
export const PASSWORD_RESET_INIT_PATH = '/account/password-reset/init';
export const PASSWORD_RESET_PATH = '/account/password-reset';

@Injectable()
export class RegisterService {

  constructor(private apiService: ApiService) {
  }

  get(): Observable<any> {
    return this.apiService.get(ACCOUNT_PATH);
  }

  save(account: Account): Observable<any> {
    return this.apiService.post(REGISTER_PATH, account);
  }

  activate(key: string): Observable<any> {
    return this.apiService.get(ACTIVATE_PATH, new HttpParams({fromObject: {'key': key}}));
  }

  initPasswordReset(email: string): Observable<any> {
    return this.apiService.post(PASSWORD_RESET_INIT_PATH, {email: email});
  }

  passwordReset(passwordReset: PasswordReset): Observable<any> {
    return this.apiService.post(PASSWORD_RESET_PATH, passwordReset);
  }

}
