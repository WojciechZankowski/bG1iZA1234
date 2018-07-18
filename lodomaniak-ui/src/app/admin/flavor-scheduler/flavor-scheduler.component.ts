import { Component, OnInit } from '@angular/core';
import { MatDialog, PageEvent } from '@angular/material';

import { FlavorService } from '../../services/flavor.service';
import { AddEditScheduleComponent } from './add-edit-schedule.component';
import { PageRequest } from '../../model/page-request.model';
import { FlavorSchedule } from '../../model/flavor-schedule.model';
import { Page } from '../../model/page.model';

export type GroupedSchedule = { [key: string]: FlavorSchedule[] };

@Component({
  templateUrl: './flavor-scheduler.component.html',
  styleUrls: ['./flavor-scheduler.component.scss'],
})
export class FlavorSchedulerComponent implements OnInit {

  public schedules: Page<FlavorSchedule>;
  public groupedData: GroupedSchedule;

  public length: number = 0;
  public pageSize: number = 50;
  public pageSizeOptions: number[] = [25, 50, 100];

  public readonly OBJECT_KEYS = Object.keys;

  constructor(private dialog: MatDialog,
              private flavorService: FlavorService) {
  }

  ngOnInit(): void {
    this.fetchSchedule();
  }

  fetchSchedule(): void {
    const pageRequest = new PageRequest(0, this.pageSize, 'ASC', 'date');
    this.flavorService.getSchedule(pageRequest).subscribe((schedules) => {
      this.schedules = schedules;
      this.length = schedules.totalElements;
      const groupedSchedule = this.grouped(schedules.content);
      this.groupedData = groupedSchedule;
      console.log(groupedSchedule);
    });
  }

  onPageChange(event: PageEvent): void {
    const pageRequest = new PageRequest(event.pageIndex, event.pageSize, 'ASC', 'date');
    this.flavorService.getSchedule(pageRequest).subscribe((schedules) => {
      this.schedules = schedules;
      this.length = schedules.totalElements;
    });
  }

  openAddEditDialog(): void {
    const matDialogRef = this.dialog.open(AddEditScheduleComponent, {
      height: '40vh',
      width: '600px',
    });

    matDialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.fetchSchedule();
      }
    });
  }

  grouped(schedules: FlavorSchedule[]): GroupedSchedule {
    if (!schedules) {
      return {};
    }

    const grouped: GroupedSchedule = {};

    schedules.forEach((schedule) => {
      const key: string = schedule.date.toString();
      let groupedElement = grouped[key];
      if (!groupedElement) {
        groupedElement = [];
      }
      groupedElement.push(schedule);
      grouped[key] = groupedElement;
    });

    return grouped;
  }

}
