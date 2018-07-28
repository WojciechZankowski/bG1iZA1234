import { Component, OnInit } from "@angular/core";
import { IceCreamShopService } from "../../app/services/ice-cream-shop.service";
import { NavController } from "ionic-angular";
import { IceCreamShopsComponent } from "./ice-cream-shops.component";

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent implements OnInit {

  public cities: string[] = [];
  public selectedCity: string;

  constructor(public navCtrl: NavController,
              private iceCreamService: IceCreamShopService) {
  }

  ngOnInit(): void {
    this.iceCreamService.getCities().subscribe((cities) => {
      this.cities = cities;
    })
  }

  public onClick(): void {
    this.navCtrl.push(IceCreamShopsComponent);
  }

}
