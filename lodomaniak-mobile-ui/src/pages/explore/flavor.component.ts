import { Component, OnInit } from "@angular/core";
import { NavController, NavParams } from "ionic-angular";
import { Flavor } from "../../app/model/flavor.model";
import { FlavorSchedule } from "../../app/model/flavor-schedule.model";
import { FlavorService } from "../../app/services/flavor.service";
import { IceCreamShopComponent } from "./ice-cream-shop.component";

@Component({
  selector: 'flavor',
  templateUrl: './flavor.component.html'
})
export class FlavorComponent implements OnInit {

  public flavor: Flavor;
  public flavorSchedules: FlavorSchedule[] = [];

  constructor(public navCtrl: NavController,
              private navParams: NavParams,
              private flavorService: FlavorService) {

  }

  ngOnInit(): void {
    this.flavor = this.navParams.get('flavor');
    this.flavorService.getTodaysSchedules(this.flavor.id)
      .subscribe((flavorSchedules) => {
        this.flavorSchedules = flavorSchedules;
      });
  }

  itemSelected(flavorSchedule: FlavorSchedule): void {
    this.navCtrl.push(IceCreamShopComponent, {
      iceCreamShop: flavorSchedule.iceCreamShop
    });
  }

  getImg(): string {
    return this.flavor ? 'assets/imgs/content/' + this.flavor.imageUrl : '';
  }

}
