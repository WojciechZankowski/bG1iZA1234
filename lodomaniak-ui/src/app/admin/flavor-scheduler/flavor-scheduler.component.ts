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

  public readonly OBJECT_KEYS = Object.keys;

  public schedules: Page<FlavorSchedule>;
  public groupedData: GroupedSchedule;
  public sortedKeys: string[];

  public length: number = 0;
  public pageSize: number = 50;
  public pageSizeOptions: number[] = [25, 50, 100];

  constructor(private dialog: MatDialog,
              private flavorService: FlavorService) {
  }

  ngOnInit(): void {
    const pageRequest = new PageRequest(0, this.pageSize, 'ASC', 'date');
    this.fetchSchedule(pageRequest);
  }

  fetchSchedule(pageRequest: PageRequest): void {
    this.flavorService.getSchedule(pageRequest).subscribe((schedules) => {
      this.schedules = schedules;
      this.length = schedules.totalElements;
      const groupedSchedule = this.grouped(schedules.content);
      this.sortedKeys = this.sortKeys(groupedSchedule);
      this.groupedData = groupedSchedule;
    });
  }

  sortKeys(groupedData: GroupedSchedule): string[] {
    const sorted = [];
    for (const key in groupedData) {
      sorted[sorted.length] = key;
    }
    sorted.sort();
    return sorted;
  }

  onPageChange(event: PageEvent): void {
    const pageRequest = new PageRequest(event.pageIndex, event.pageSize, 'ASC', 'date');
    this.fetchSchedule(pageRequest);
  }

  openAddEditDialog(): void {
    const matDialogRef = this.dialog.open(AddEditScheduleComponent, {
      height: '45vh',
      width: '600px',
    });

    matDialogRef.afterClosed()
      .subscribe((result) => {
        if (result) {
          const pageRequest = new PageRequest(0, this.pageSize, 'ASC', 'date');
          this.fetchSchedule(pageRequest);
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
