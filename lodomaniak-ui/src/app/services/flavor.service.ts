import {Injectable} from "@angular/core";
import {ApiService} from "../core/api.service";
import {Observable} from "rxjs/Observable";
import {Flavor} from "../model/flavor.model";
import {PageRequest} from "../model/page-request.model";
import {FlavorSchedule} from "../model/flavor-schedule.model";
import {HttpParams} from "@angular/common/http";

export const FLAVOR_PATH = '/flavor';
export const FLAVOR_MINE_PATH = '/flavor/mine';

export const FLAVOR_SCHEDULE_PATH = "/flavor/schedule";

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

  getSchedule(request: PageRequest): Observable<Array<FlavorSchedule>> {
    const properties = new HttpParams().set('page', request.page.toString())
      .set('size', request.size.toString())
      .set('direction', request.direction)
      .set('properties', request.properties);
    return this.apiService.get(FLAVOR_SCHEDULE_PATH, properties);
  }

  saveSchedule(flavorSchedule: FlavorSchedule): Observable<any> {
    return this.apiService.post(FLAVOR_SCHEDULE_PATH, flavorSchedule);
  }

  updateSchedule(flavorSchedule: FlavorSchedule): Observable<any> {
    return this.apiService.put(FLAVOR_SCHEDULE_PATH, flavorSchedule);
  }

}
