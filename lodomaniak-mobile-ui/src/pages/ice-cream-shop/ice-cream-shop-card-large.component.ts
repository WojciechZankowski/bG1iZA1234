import { Component, Input } from "@angular/core";
import { IceCreamShop } from "../../app/model/ice-cream-shop.model";
import { OpeningHoursRange } from "../../app/model/opening-hours-range.model";
import { DayOfWeek } from "../../app/model/day-of-week.model";

@Component({
  selector: 'ice-cream-shop-card-large',
  templateUrl: './ice-cream-shop-card-large.component.html'
})
export class IceCreamShopCardLargeComponent {

  @Input()
  public iceCreamShop: IceCreamShop;

  getImg(): string {
    return this.iceCreamShop ? 'assets/imgs/content/' + this.iceCreamShop.imageUrl : '';
  }

  getOpeningHours(): string {
    const openingHoursRange = this.getOpeningHoursRange();
    return openingHoursRange.openHour + ' - ' + openingHoursRange.closeHour;
  }

  getOpeningHoursRange(): OpeningHoursRange {
    return this.iceCreamShop.openingHours[DayOfWeek[new Date().getDay()]];
  }

}
