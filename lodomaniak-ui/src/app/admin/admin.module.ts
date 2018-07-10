import {NgModule} from "@angular/core";
import {AdminRoutingModule} from "./admin.routing.module";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {FlavorSchedulerComponent} from "./flavor-scheduler/flavor-scheduler.component";
import {FlavorsComponent} from "./flavors/flavors.component";
import {IceCreamShopsComponent} from "./ice-cream-shops/ice-cream-shops.component";
import {AdminComponent} from "./admin.component";
import {SharedModule} from "../shared/shared.module";
import {BrowserModule} from "@angular/platform-browser";

@NgModule({
  imports: [
    AdminRoutingModule,
    SharedModule
  ],
  declarations: [
    AdminComponent,
    DashboardComponent,
    FlavorSchedulerComponent,
    FlavorsComponent,
    IceCreamShopsComponent
  ],
  entryComponents: [
    AdminComponent,
    DashboardComponent,
    FlavorSchedulerComponent,
    FlavorsComponent,
    IceCreamShopsComponent
  ]
})
export class AdminModule {

}
