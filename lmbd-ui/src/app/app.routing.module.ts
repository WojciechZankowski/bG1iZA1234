import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {LoansComponent} from "./features/loans/loans.component";
import {DashboardComponent} from "./features/dashboard/dashboard.component";
import {HistoryComponent} from "./features/history/history.component";

const routes: Routes = [
  {
    path: '',
    component: DashboardComponent
  },
  {
    path: 'loans',
    component: LoansComponent
  },
  {
    path: 'history',
    component: HistoryComponent
  },
  {
    path: 'profile',
    loadChildren: './features/profile/profile.module#ProfileModule'
  },
  {
    path: 'account',
    loadChildren: './account/account.module#AccountModule'
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
