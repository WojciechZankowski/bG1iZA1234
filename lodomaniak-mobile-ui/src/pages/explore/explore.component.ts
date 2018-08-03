import { Component, OnInit } from '@angular/core';
import { Events, NavController } from 'ionic-angular';
import { Facebook, FacebookLoginResponse } from '@ionic-native/facebook';
import { IceCreamShopService } from "../../app/services/ice-cream-shop.service";
import { IceCreamShop } from "../../app/model/ice-cream-shop.model";
import { FlavorService } from "../../app/services/flavor.service";
import { FlavorSchedule } from "../../app/model/flavor-schedule.model";
import { IceCreamShopsComponent } from "./ice-cream-shops.component";
import { FlavorsComponent } from "./flavors.component";
import { CityService } from "../../app/services/city.service";
import { FlavorTodayComponent } from "./flavor-today.component";

@Component({
  selector: 'lodomaniak-explore',
  templateUrl: './explore.component.html'
})
export class ExplorePage implements OnInit{

  public iceCreamShops: IceCreamShop[];
  public flavorsSchedules: FlavorSchedule[];
  public flavorSchedulesKrakow: FlavorSchedule[];

  constructor(public navCtrl: NavController,
              private fb: Facebook,
              private iceCreamService: IceCreamShopService,
              private cityService: CityService,
              private flavorService: FlavorService,
              public events: Events) {
    this.events.subscribe(CityService.CITY_KEY, (city) => {
      this.fetchData(city);
    });
  }

  ngOnInit(): void {
    this.cityService.getCity()
      .then((city) => {
        this.fetchData(city);
      })

    this.flavorService.getTodaysFlavors('Kraków').subscribe((flavorsSchedules) => {
      this.flavorSchedulesKrakow = flavorsSchedules;
    });
  }

  fetchData(city: string): void {
    this.iceCreamService.getLatelyAdded(city).subscribe((iceCreamShops) => {
      this.iceCreamShops = iceCreamShops;
    });

    this.flavorService.getTodaysFlavors(city).subscribe((flavorsSchedules) => {
      this.flavorsSchedules = flavorsSchedules;
    });
  }

  signin(): void {
    this.fb.login(['public_profile', 'email'])
      .then((res: FacebookLoginResponse) => console.log('Logged into Facebook!', res))
      .catch(e => console.log('Error logging into Facebook', e));
  }

  onCityChange(event: string): void {
    this.fetchData(event);
  }

  navigateToShops(): void {
    this.navCtrl.push(IceCreamShopsComponent);
  }

  navigateToFlavors(): void {
    this.navCtrl.push(FlavorsComponent);
  }

  navigateToFlavorToday(flavorSchedules: FlavorSchedule[]): void {
    this.navCtrl.push(FlavorTodayComponent, {
      flavorSchedules: flavorSchedules
    })
  }

}
