import { Component, Input } from "@angular/core";
import { FlavorSchedule } from "../../app/model/flavor-schedule.model";
import { NavController } from "ionic-angular";
import { FlavorComponent } from "./flavor.component";
import { RatingType } from "../../app/model/rating-type.model";

@Component({
  selector: 'flavor-schedule-card',
  templateUrl: './flavor-schedule-card.component.html'
})
export class FlavorScheduleCardComponent {

  @Input()
  public flavorSchedule: FlavorSchedule;

  public readonly RATING_TYPE = RatingType.FLAVOR;

  constructor(public navCtrl: NavController) {
  }

  getImg(): string {
    return this.flavorSchedule ? 'assets/imgs/content/' + this.flavorSchedule.flavor.imageUrl : '';
  }

  onClick(): void {
    this.navCtrl.push(FlavorComponent, {
      flavor: this.flavorSchedule.flavor
    });
  }

}
