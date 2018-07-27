import { Component, Input } from "@angular/core";
import { FlavorSchedule } from "../../app/model/flavor-schedule.model";

@Component({
  selector: 'flavor-card',
  templateUrl: './flavor-card.component.html'
})
export class FlavorCardComponent {

  @Input()
  public flavorSchedule: FlavorSchedule;

  getImg(): string {
    return this.flavorSchedule ? 'assets/imgs/content/' + this.flavorSchedule.flavor.imageUrl : '';
  }

}
