import { Component, OnInit } from "@angular/core";
import { IceCreamShop } from "../../app/model/ice-cream-shop.model";
import { FlavorService } from "../../app/services/flavor.service";
import { NavController, NavParams } from "ionic-angular";
import { FlavorSchedule } from "../../app/model/flavor-schedule.model";
import { DayOfWeek } from "../../app/model/day-of-week.model";
import { RatingType } from "../../app/model/rating-type.model";

@Component({
  selector: 'ice-cream-shop',
  templateUrl: './ice-cream-shop.component.html'
})
export class IceCreamShopComponent implements OnInit {

  public readonly RATING_TYPE = RatingType.ICE_CREAM_SHOP;

  public readonly DAY_OF_WEEK = Object.keys(DayOfWeek)
    .map(key => DayOfWeek[key])
    .filter(value => typeof value === 'string') as string[];

  public readonly TRANSLATIONS = {
    'MONDAY': 'Poniedziałek',
    'TUESDAY': 'Wtorek',
    'WEDNESDAY': 'Środa',
    'THURSDAY': 'Czwartek',
    'FRIDAY': 'Piątek',
    'SATURDAY': 'Sobota',
    'SUNDAY': 'Niedziela',
  };

  public iceCreamShopSchedules: FlavorSchedule[] = [];

  public iceCreamShop: IceCreamShop;

  constructor(public navCtrl: NavController,
              private navParams: NavParams,
              private flavorService: FlavorService) {
  }

  ngOnInit(): void {
    this.iceCreamShop = this.navParams.get('iceCreamShop');
    this.flavorService.getTodaysSchedulesForIceCreamShop(this.iceCreamShop.id)
      .subscribe((iceCreamShopSchedules) => {
        this.iceCreamShopSchedules = iceCreamShopSchedules;
      });
  }

  getImg(): string {
    return this.iceCreamShop ? 'assets/imgs/content/' + this.iceCreamShop.imageUrl : '';
  }

}
