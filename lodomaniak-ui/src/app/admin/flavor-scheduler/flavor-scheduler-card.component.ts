import {Component, Input} from "@angular/core";
import {FlavorSchedule} from "../../model/flavor-schedule.model";
import {MatDialog} from "@angular/material";
import {AddEditFlavorComponent} from "../flavors/add-edit-flavor.component";
import {AddEditScheduleComponent} from "./add-edit-schedule.component";

@Component({
  selector: 'flavor-scheduler-card',
  templateUrl: './flavor-scheduler-card.component.html',
  styleUrls: ['./flavor-scheduler-card.component.scss']
})
export class FlavorSchedulerCardComponent {

  @Input()
  public flavorSchedule: FlavorSchedule;

  constructor(private dialog: MatDialog) {}

  edit(): void {
    this.dialog.open(AddEditScheduleComponent, {
      height: '40vh',
      width: '600px',
      data: {
        flavor: this.flavorSchedule
      }
    });
  }

  getFilePath(name: string) {
    return '/assets/img/content/' + name;
  }

}
