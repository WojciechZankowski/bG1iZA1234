import { Component, Input } from "@angular/core";
import { IceCreamShop } from "../../app/model/ice-cream-shop.model";

@Component({
  selector: 'ice-cream-shop-card',
  templateUrl: './ice-cream-shop-card.component.html',
})
export class IceCreamShopCardComponent {

  @Input()
  public iceCreamShop: IceCreamShop;

  getImg(): string {
    return this.iceCreamShop ? 'assets/imgs/content/' + this.iceCreamShop.imageUrl : '';
  }

}
