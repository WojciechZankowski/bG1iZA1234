import {Component, OnInit} from "@angular/core";
import {MatDialog, PageEvent} from "@angular/material";
import {FlavorService} from "../../services/flavor.service";
import {AddEditScheduleComponent} from "./add-edit-schedule.component";
import {PageRequest} from "../../model/page-request.model";
import {FlavorSchedule} from "../../model/flavor-schedule.model";
import {Page} from "../../model/page.model";

@Component({
  templateUrl: './flavor-scheduler.component.html',
  styleUrls: ['./flavor-scheduler.component.scss']
})
export class FlavorSchedulerComponent implements OnInit {

  public schedules: Page<FlavorSchedule>;

  public length: number = 0;
  public pageSize: number = 25;
  public pageSizeOptions: Array<number> = [10, 25, 50];

  constructor(private dialog: MatDialog,
              private flavorService: FlavorService) {
  }

  ngOnInit(): void {
    this.fetchSchedule();
  }

  fetchSchedule(): void {
    const pageRequest = new PageRequest(0, this.pageSize, 'ASC', 'date');
    this.flavorService.getSchedule(pageRequest).subscribe(schedules => {
      this.schedules = schedules;
      this.length = schedules.totalElements;
    });
  }

  onPageChange(event: PageEvent): void {
    const pageRequest = new PageRequest(event.pageIndex, event.pageSize, 'ASC', 'date');
    this.flavorService.getSchedule(pageRequest).subscribe(schedules => {
      this.schedules = schedules;
      this.length = schedules.totalElements;
    });
  }

  openAddEditDialog(): void {
    let matDialogRef = this.dialog.open(AddEditScheduleComponent, {
      height: '50vh',
      width: '600px',
    });

    matDialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.fetchSchedule();
      }
    });
  }

}
