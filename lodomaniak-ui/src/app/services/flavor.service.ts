import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpParams } from '@angular/common/http';

import { Flavor } from '../model/flavor.model';
import { PageRequest } from '../model/page-request.model';
import { FlavorSchedule } from '../model/flavor-schedule.model';
import { Page } from '../model/page.model';
import { ApiService } from '../core/api.service';

export const FLAVOR_PATH = '/flavor';
export const FLAVOR_MINE_PATH = '/flavor/mine';

export const FLAVOR_SCHEDULE_PATH = '/flavor/schedule';

@Injectable()
export class FlavorService {

  constructor(private apiService: ApiService) {}

  save(flavor: Flavor): Observable<any> {
    return this.apiService.post(FLAVOR_PATH, flavor);
  }

  update(flavor: Flavor): Observable<any> {
    return this.apiService.put(FLAVOR_PATH, flavor);
  }

  getFlavors(request: PageRequest): Observable<Page<Flavor>> {
    const properties = new HttpParams().set('page', request.page.toString())
      .set('size', request.size.toString());
    return this.apiService.get(FLAVOR_MINE_PATH, properties);
  }

  getSchedule(request: PageRequest): Observable<Page<FlavorSchedule>> {
    const properties = new HttpParams().set('page', request.page.toString())
      .set('size', request.size.toString())
      .set('sort', request.sort)
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
