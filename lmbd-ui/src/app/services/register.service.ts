import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";

import {ApiService} from "../core/api.service";
import {Account} from "../model/account.model";

export const REGISTER_PATH = '/register';

@Injectable()
export class RegisterService {

  constructor(private apiService: ApiService) {
  }

  save(account: Account): Observable<any> {
    return this.apiService.post(REGISTER_PATH, account);
  }

}
