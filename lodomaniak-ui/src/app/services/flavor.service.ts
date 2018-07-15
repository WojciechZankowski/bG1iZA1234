import {Injectable} from "@angular/core";
import {ApiService} from "../core/api.service";
import {Observable} from "rxjs/Observable";
import {Flavor} from "../model/flavor.model";

export const FLAVOR_PATH = '/flavor';
export const FLAVOR_MINE_PATH = '/flavor/mine';

@Injectable()
export class FlavorService {

  constructor(private apiService: ApiService) {}

  save(flavor: Flavor): Observable<any> {
    return this.apiService.post(FLAVOR_PATH, flavor);
  }

  update(flavor: Flavor): Observable<any> {
    return this.apiService.put(FLAVOR_PATH, flavor);
  }

  getFlavors(): Observable<Array<Flavor>> {
    return this.apiService.get(FLAVOR_MINE_PATH);
  }

}
