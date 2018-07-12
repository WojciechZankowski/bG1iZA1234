import {NgModule} from "@angular/core";
import {AdminRoutingModule} from "./admin.routing.module";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {FlavorSchedulerComponent} from "./flavor-scheduler/flavor-scheduler.component";
import {FlavorsComponent} from "./flavors/flavors.component";
import {IceCreamShopsComponent} from "./ice-cream-shops/ice-cream-shops.component";
import {AdminComponent} from "./admin.component";
import {SharedModule} from "../shared/shared.module";
import {BrowserModule} from "@angular/platform-browser";
import {IceCreamShopsModule} from "./ice-cream-shops/ice-cream-shops.module";

@NgModule({
  imports: [
    AdminRoutingModule,
    IceCreamShopsModule,
    SharedModule
  ],
  declarations: [
    AdminComponent,
    DashboardComponent,
    FlavorSchedulerComponent,
    FlavorsComponent
  ],
  entryComponents: [
    AdminComponent,
    DashboardComponent,
    FlavorSchedulerComponent,
    FlavorsComponent
  ]
})
export class AdminModule {

}
