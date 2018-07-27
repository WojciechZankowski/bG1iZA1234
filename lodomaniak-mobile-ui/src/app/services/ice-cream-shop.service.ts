import { Injectable } from "@angular/core";
import { ApiService } from "../core/api.service";
import { IceCreamShop } from "../model/ice-cream-shop.model";
import { Observable } from "rxjs/Observable";
import { HttpParams } from "@angular/common/http";

export const LATELY_ADDED_PATH = '/icecreamshop/last';
export const CITIES_PATH = '/icecreamshop/cities';

@Injectable()
export class IceCreamShopService {

  constructor(private apiService: ApiService) {

  }

  public getCities(): Observable<string[]> {
    return this.apiService.get(CITIES_PATH);
  }

  public getLatelyAdded(city: string): Observable<IceCreamShop[]> {
    return this.apiService.get(LATELY_ADDED_PATH, new HttpParams({ fromObject: { city: city } }));
  }

}
