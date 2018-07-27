import { Injectable } from "@angular/core";
import { FlavorSchedule } from "../model/flavor-schedule.model";
import { ApiService } from "../core/api.service";
import { HttpParams } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

export const FLAVORS_SCHEDULE = '/flavor/schedule/today';

@Injectable()
export class FlavorService {

  constructor(private apiService: ApiService) {
  }

  getTodaysFlavors(city: string): Observable<FlavorSchedule[]> {
    return this.apiService.get(FLAVORS_SCHEDULE, new HttpParams({ fromObject: { city: city } }))
  }

  getTodaysSchedules(flavorId: string): Observable<FlavorSchedule[]> {
    return this.apiService.get(FLAVORS_SCHEDULE, new HttpParams({ fromObject: { flavorId: flavorId } }))
  }

}
