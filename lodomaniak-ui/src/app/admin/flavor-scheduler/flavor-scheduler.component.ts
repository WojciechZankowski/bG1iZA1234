import {Component, OnInit} from "@angular/core";
import {MatDialog} from "@angular/material";
import {FlavorService} from "../../services/flavor.service";
import {AddEditScheduleComponent} from "./add-edit-schedule.component";
import {PageRequest} from "../../model/page-request.model";
import {FlavorSchedule} from "../../model/flavor-schedule.model";

@Component({
  templateUrl: './flavor-scheduler.component.html',
  styleUrls: ['./flavor-scheduler.component.scss']
})
export class FlavorSchedulerComponent implements OnInit {

  public schedules: Array<FlavorSchedule> = [];

  public length: number = 0;


  constructor(private dialog: MatDialog,
              private flavorService: FlavorService) {
  }

  ngOnInit(): void {
    this.fetchSchedule();
  }

  fetchSchedule(): void {
    const pageRequest = new PageRequest(0, 50, 'ASC', 'date');
    this.flavorService.getSchedule(pageRequest).subscribe(schedules => {
      this.schedules = schedules;
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
