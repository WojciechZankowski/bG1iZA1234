import {NgModule} from "@angular/core";
import {Route, RouterModule} from "@angular/router";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {AccountComponent} from "./account.component";
import {PasswordResetInitComponent} from "./reset-password/password-reset-init.component";
import {ActivateComponent} from "./activate/activate.component";
import {PasswordResetComponent} from "./reset-password/password-reset.component";

const routes: Array<Route> = [
  {
    path: '',
    component: AccountComponent,
    children: [
      {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
      },
      {
        path: 'register',
        component: RegisterComponent
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'activate',
        component: ActivateComponent
      },
      {
        path: 'password-reset',
        component: PasswordResetInitComponent
      },
      {
        path: 'password-reset/finish',
        component: PasswordResetComponent
      }
    ]
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
