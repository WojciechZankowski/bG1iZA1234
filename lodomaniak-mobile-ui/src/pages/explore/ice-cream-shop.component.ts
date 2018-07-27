import { Component, OnInit } from "@angular/core";
import { IceCreamShop } from "../../app/model/ice-cream-shop.model";
import { FlavorService } from "../../app/services/flavor.service";
import { NavParams } from "ionic-angular";

@Component({
  selector: 'ice-cream-shop',
  templateUrl: './ice-cream-shop.component.html'
})
export class IceCreamShopComponent implements OnInit {

  public iceCreamShop: IceCreamShop;

  constructor(private navParams: NavParams,
              private flavorService: FlavorService) {
  }

  ngOnInit(): void {
    this.iceCreamShop = this.navParams.get('iceCreamShop');
  }

}
