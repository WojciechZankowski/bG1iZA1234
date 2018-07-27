import { Flavor } from './flavor.model';
import { IceCreamShop } from './ice-cream-shop.model';

export class FlavorSchedule {
  id: number;
  date: Date;
  flavor: Flavor;
  iceCreamShop: IceCreamShop;

  constructor(id?: number, date?: Date, flavor?: Flavor, iceCreamShop?: IceCreamShop) {
    this.id = id;
    this.date = date;
    this.flavor = flavor;
    this.iceCreamShop = iceCreamShop;
  }
}
