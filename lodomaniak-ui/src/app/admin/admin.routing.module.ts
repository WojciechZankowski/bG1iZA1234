import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {ProfileSettingsComponent} from "../features/profile/settings/profile-settings.component";
import {ProfileComponent} from "../features/profile/profile.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {FlavorsComponent} from "./flavors/flavors.component";
import {FlavorSchedulerComponent} from "./flavor-scheduler/flavor-scheduler.component";
import {IceCreamShopsComponent} from "./ice-cream-shops/ice-cream-shops.component";

const routes: Routes = [
  {
    path: '',
    component: DashboardComponent
  },
  {
    path: 'flavors',
    component: FlavorsComponent
  },
  {
    path: 'flavor-scheduler',
    component: FlavorSchedulerComponent
  },
  {
    path: 'shops',
    component: IceCreamShopsComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AdminRoutingModule {

}
