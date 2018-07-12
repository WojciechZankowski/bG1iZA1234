import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Company} from "../model/company.model";
import {ApiService} from "../core/api.service";

export const COMPANY_PATH = '/company/mine';

@Injectable()
export class CompanyService {

  constructor(private apiService: ApiService) {}

  getCompanies(): Observable<Array<Company>> {
    return this.apiService.get(COMPANY_PATH);
  }

}
