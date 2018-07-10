import {NgModule} from "@angular/core";
import {DashboardModule} from "./dashboard/dashboard.module";

@NgModule({
  imports: [
    DashboardModule
  ],
  exports: [
    DashboardModule
  ]
})
export class FeaturesModule {

}
