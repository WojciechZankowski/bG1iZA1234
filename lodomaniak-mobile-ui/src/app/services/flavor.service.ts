import { Injectable } from "@angular/core";
import { FlavorSchedule } from "../model/flavor-schedule.model";
import { ApiService } from "../core/api.service";
import { HttpParams } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { PageRequest } from "../model/page-request.model";
import { Flavor } from "../model/flavor.model";

export const FLAVOR_PATH = '/flavor';
export const FLAVORS_SCHEDULE = '/flavor/schedule/today';

@Injectable()
export class FlavorService {

  constructor(private apiService: ApiService) {
  }

  getFlavors(name: string, city: string, page: PageRequest): Observable<Flavor[]> {
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

}