import { Component, Input } from "@angular/core";
import { IceCreamShop } from "../../app/model/ice-cream-shop.model";
import { NavController } from "ionic-angular";
import { IceCreamShopComponent } from "./ice-cream-shop.component";
import { RatingType } from "../../app/model/rating-type.model";

@Component({
  selector: 'ice-cream-shop-card',
  templateUrl: './ice-cream-shop-card.component.html',
})
export class IceCreamShopCardComponent {

  public readonly RATING_TYPE = RatingType.ICE_CREAM_SHOP;

  @Input()
  public iceCreamShop: IceCreamShop;

  constructor(public navCtrl: NavController) {
  }

  getImg(): string {
    return this.iceCreamShop ? 'assets/imgs/content/' + this.iceCreamShop.imageUrl : '';
  }

  onClick(): void {
    this.navCtrl.push(IceCreamShopComponent, {
      iceCreamShop: this.iceCreamShop
    });
  }

}
