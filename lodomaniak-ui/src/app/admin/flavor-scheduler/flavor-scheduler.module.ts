import {NgModule} from "@angular/core";
import {FlavorSchedulerComponent} from "./flavor-scheduler.component";
import {AddEditScheduleComponent} from "./add-edit-schedule.component";
import {FlexLayoutModule} from "@angular/flex-layout";
import {FormsModule} from "@angular/forms";
import {SharedModule} from "../../shared/shared.module";
import {FlavorSchedulerCardComponent} from "./flavor-scheduler-card.component";

@NgModule({
  imports:  [
    SharedModule,
    FormsModule,
    FlexLayoutModule
  ],
  entryComponents: [
    FlavorSchedulerComponent,
    AddEditScheduleComponent,
    FlavorSchedulerCardComponent
  ],
  declarations: [
    FlavorSchedulerComponent,
    AddEditScheduleComponent,
    FlavorSchedulerCardComponent
  ]
})
export class FlavorSchedulerModule {

}
