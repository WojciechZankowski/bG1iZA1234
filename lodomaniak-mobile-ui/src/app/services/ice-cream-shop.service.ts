import { Injectable } from "@angular/core";
import { ApiService } from "../core/api.service";
import { IceCreamShop } from "../model/ice-cream-shop.model";
import { Observable } from "rxjs/Observable";
import { HttpParams } from "@angular/common/http";
import { PageRequest } from "../model/page-request.model";
import { Page } from "../model/page.model";

export const SHOPS_PATH = '/icecreamshop';
export const LATELY_ADDED_PATH = '/icecreamshop/last';
export const CITIES_PATH = '/icecreamshop/cities';

@Injectable()
export class IceCreamShopService {

  constructor(private apiService: ApiService) {
  }

  getIceCreamShops(name: string, city: string, page: PageRequest): Observable<Page<IceCreamShop>> {
    return this.apiService.get(SHOPS_PATH, new HttpParams({
      fromObject: {
        name: name,
        city: city,
        page: page.page.toString(),
        size: page.size.toString()
      }
    }))
  }

  public getCities(): Observable<string[]> {
    return this.apiService.get(CITIES_PATH);
  }

  public getLatelyAdded(city: string): Observable<IceCreamShop[]> {
    return this.apiService.get(LATELY_ADDED_PATH, new HttpParams({ fromObject: { city: city } }));
  }

}
