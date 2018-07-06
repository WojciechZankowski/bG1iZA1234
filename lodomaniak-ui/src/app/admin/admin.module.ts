import {NgModule} from "@angular/core";
import {AdminRoutingModule} from "./admin.routing.module";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {FlavorSchedulerComponent} from "./flavor-scheduler/flavor-scheduler.component";
import {FlavorsComponent} from "./flavors/flavors.component";
import {IceCreamShopsComponent} from "./ice-cream-shops/ice-cream-shops.component";

@NgModule({
  imports: [
    AdminRoutingModule
  ],
  declarations: [
    DashboardComponent,
    FlavorSchedulerComponent,
    FlavorsComponent,
    IceCreamShopsComponent
  ],
  entryComponents: [
    DashboardComponent,
    FlavorSchedulerComponent,
    FlavorsComponent,
    IceCreamShopsComponent
  ]
})
export class AdminModule {

}
