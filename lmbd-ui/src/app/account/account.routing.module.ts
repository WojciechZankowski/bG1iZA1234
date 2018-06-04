import {NgModule} from "@angular/core";
import {Route, RouterModule} from "@angular/router";
import {RegisterComponent} from "./register/register.component";
import {ProfileComponent} from "../features/profile/profile.component";

const routes: Array<Route> = [
  {
    path: '',
    component: RegisterComponent
  },
  {
    path: 'register',
    component: RegisterComponent
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
export class AccountRoutingModule {
}
