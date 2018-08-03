import { Injectable } from "@angular/core";
import { FlavorSchedule } from "../model/flavor-schedule.model";
import { ApiService } from "../core/api.service";
import { HttpParams } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { PageRequest } from "../model/page-request.model";
import { Flavor } from "../model/flavor.model";
import { Page } from "../model/page.model";

export const FLAVOR_PATH = '/flavor';
export const FLAVOR_TOP_PATH = '/flavor/top';
export const FLAVORS_SCHEDULE = '/flavor/schedule/today';
export const MY_TODAYS_FLAVORS_SCHEDULE = '/flavor/schedule/mine/today';
export const MY_FLAVORS = '/flavor/mine/follow';

@Injectable()
export class FlavorService {

  constructor(private apiService: ApiService) {
  }

  getFlavors(name: string, city: string, page: PageRequest): Observable<Page<Flavor>> {
    return this.apiService.get(FLAVOR_PATH, new HttpParams({
      fromObject: {
        name: name,
        city: city,
        page: page.page.toString(),
        size: page.size.toString()
      }
    }))
  }

  getTodaysFlavors(city: string): Observable<FlavorSchedule[]> {
    return this.apiService.get(FLAVORS_SCHEDULE, new HttpParams({ fromObject: { city: city } }))
  }

  getTodaysSchedules(flavorId: number): Observable<FlavorSchedule[]> {
    return this.apiService.get(FLAVORS_SCHEDULE, new HttpParams({ fromObject: { flavorId: flavorId.toString() } }))
  }

  getTodaysSchedulesForIceCreamShop(iceCreamShopId: number): Observable<FlavorSchedule[]> {
    return this.apiService.get(FLAVORS_SCHEDULE, new HttpParams({ fromObject: { iceCreamShopId: iceCreamShopId.toString() } }))
  }

  getTopFlavors(city: string): Observable<Flavor[]> {
    return this.apiService.get(FLAVOR_TOP_PATH, new HttpParams({ fromObject: { city: city } }));
  }

  getFollowedFlavors(): Observable<Flavor[]> {
    return this.apiService.get(MY_FLAVORS);
  }

  getMyFlavorsScheduledForToday(): Observable<FlavorSchedule[]> {
    return this.apiService.get(MY_TODAYS_FLAVORS_SCHEDULE);
  }

}
