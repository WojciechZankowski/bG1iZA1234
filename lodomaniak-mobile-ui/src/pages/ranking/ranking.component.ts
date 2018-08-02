import { Component, OnInit } from "@angular/core";
import { Events } from "ionic-angular";
import { IceCreamShopService } from "../../app/services/ice-cream-shop.service";
import { FlavorService } from "../../app/services/flavor.service";
import { IceCreamShop } from "../../app/model/ice-cream-shop.model";
import { Flavor } from "../../app/model/flavor.model";
import { CityService } from "../../app/services/city.service";

@Component({
  templateUrl: './ranking.component.html'
})
export class RankingPage implements OnInit {

  public topIceCreamShops: IceCreamShop[];
  public topFlavors: Flavor[];

  public topWroclaw: IceCreamShop[];
  public topKrakow: IceCreamShop[];

  constructor(private iceCreamService: IceCreamShopService,
              private flavorService: FlavorService,
              private cityService: CityService,
              public events: Events) {
    this.events.subscribe(CityService.CITY_KEY, (city) => {
      this.fetchData(city);
    });
  }

  ngOnInit(): void {
    this.cityService.getCity()
      .then((value) => {
        this.fetchData(value);
      });

    this.iceCreamService.getTopIceCreamShops('Wrocław')
      .subscribe((iceCreamShops) => {
        this.topWroclaw = iceCreamShops;
      });

    this.iceCreamService.getTopIceCreamShops('Kraków')
      .subscribe((iceCreamShops) => {
        this.topKrakow = iceCreamShops;
      });
  }


  fetchData(city: string): void {
    this.flavorService.getTopFlavors(city)
      .subscribe((flavors) => {
        this.topFlavors = flavors;
      });
    this.iceCreamService.getTopIceCreamShops(city)
      .subscribe((iceCreamShops) => {
        this.topIceCreamShops = iceCreamShops;
      });
  }
}
