import { Component, Input } from "@angular/core";
import { FlavorSchedule } from "../../app/model/flavor-schedule.model";
import { NavParams } from "ionic-angular";

@Component({
  selector: 'flavor-today',
  templateUrl: './flavor-today.component.html'
})
export class FlavorTodayComponent {

  public flavorSchedules: FlavorSchedule[];

  constructor(private navParams: NavParams) {
    this.flavorSchedules = this.navParams.get('flavorSchedules');
  }

}
