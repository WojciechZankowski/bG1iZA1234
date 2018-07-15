import {NgModule} from "@angular/core";
import {AdminRoutingModule} from "./admin.routing.module";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {FlavorSchedulerComponent} from "./flavor-scheduler/flavor-scheduler.component";
import {FlavorsComponent} from "./flavors/flavors.component";
import {AdminComponent} from "./admin.component";
import {SharedModule} from "../shared/shared.module";
import {IceCreamShopsModule} from "./ice-cream-shops/ice-cream-shops.module";
import {FlavorsModule} from "./flavors/flavors.module";

@NgModule({
  imports: [
    AdminRoutingModule,
    IceCreamShopsModule,
    FlavorsModule,
    SharedModule
  ],
  declarations: [
    AdminComponent,
    DashboardComponent,
    FlavorSchedulerComponent
  ],
  entryComponents: [
    AdminComponent,
    DashboardComponent,
    FlavorSchedulerComponent
  ]
})
export class AdminModule {

}
