import { Component, Input } from "@angular/core";
import { FlavorSchedule } from "../../app/model/flavor-schedule.model";
import { NavController } from "ionic-angular";
import { FlavorComponent } from "./flavor.component";

@Component({
  selector: 'flavor-card',
  templateUrl: './flavor-card.component.html'
})
export class FlavorCardComponent {

  @Input()
  public flavorSchedule: FlavorSchedule;

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
