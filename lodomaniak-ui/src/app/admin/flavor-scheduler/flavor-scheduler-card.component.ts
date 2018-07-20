import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material';

import { FlavorSchedule } from '../../model/flavor-schedule.model';
import { AddEditScheduleComponent } from './add-edit-schedule.component';

@Component({
  selector: 'flavor-scheduler-card',
  templateUrl: './flavor-scheduler-card.component.html',
})
export class FlavorSchedulerCardComponent {

  @Input()
  public flavorSchedule: FlavorSchedule;

  constructor(private dialog: MatDialog) {
  }

  edit(): void {
    this.dialog.open(AddEditScheduleComponent, {
      height: '45vh',
      width: '600px',
      data: {
        flavorSchedule: this.flavorSchedule,
      },
    });
  }

  getFilePath(name: string) {
    return '/assets/img/content/' + name;
  }

}
