import { Component, Input } from "@angular/core";
import { IceCreamShop } from "../../app/model/ice-cream-shop.model";
import { FlavorComponent } from "./flavor.component";
import { NavController } from "ionic-angular";
import { IceCreamShopComponent } from "./ice-cream-shop.component";

@Component({
  selector: 'ice-cream-shop-card',
  templateUrl: './ice-cream-shop-card.component.html',
})
export class IceCreamShopCardComponent {

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
