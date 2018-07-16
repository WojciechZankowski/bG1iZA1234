import {Component, Input} from "@angular/core";
import {FlavorSchedule} from "../../model/flavor-schedule.model";

@Component({
  selector: 'flavor-scheduler-card',
  templateUrl: './flavor-scheduler-card.component.html',
  styleUrls: ['./flavor-scheduler-card.component.scss']
})
export class FlavorSchedulerCardComponent {

  @Input()
  public flavorSchedule: FlavorSchedule;

  edit(): void {

  }

}
