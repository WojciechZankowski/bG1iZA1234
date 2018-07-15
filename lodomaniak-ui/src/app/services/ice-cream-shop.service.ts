import {Injectable} from "@angular/core";
import {ApiService} from "../core/api.service";
import {IceCreamShop} from "../model/ice-cream-shop.model";
import {Observable} from "rxjs/Observable";

export const ICE_CREAM_SHOP_PATH = '/icecreamshop';
export const ICE_CREAM_SHOP_GET_PATH = '/icecreamshop/mine';

@Injectable()
export class IceCreamShopService {

  constructor(private apiService: ApiService) {}

  save(iceCreamShop: IceCreamShop): Observable<any> {
    return this.apiService.post(ICE_CREAM_SHOP_PATH, iceCreamShop);
  }

  update(iceCreamShop: IceCreamShop): Observable<any> {
    return this.apiService.put(ICE_CREAM_SHOP_PATH, iceCreamShop);
  }

  getIceCreamShops(): Observable<Array<IceCreamShop>> {
    return this.apiService.get(ICE_CREAM_SHOP_GET_PATH);
  }

}
