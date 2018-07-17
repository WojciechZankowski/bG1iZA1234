import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {FlavorsComponent} from "./flavors/flavors.component";
import {FlavorSchedulerComponent} from "./flavor-scheduler/flavor-scheduler.component";
import {IceCreamShopsComponent} from "./ice-cream-shops/ice-cream-shops.component";
import {AdminComponent} from "./admin.component";
import {UserRouteAccessService} from "../services/user-route-access.service";

const routes: Routes = [
  {
    path: '',
    data: {
      authorities: ['ROLE_ADMIN']
    },
    canActivate: [UserRouteAccessService],
    component: AdminComponent,
    children: [
      {
        path: '',
        redirectTo: 'shops',
        pathMatch: 'full'
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
    ],
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
