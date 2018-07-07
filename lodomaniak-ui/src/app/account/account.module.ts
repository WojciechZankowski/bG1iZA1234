import {NgModule} from "@angular/core";
import {RegisterComponent} from "./register/register.component";
import {AccountRoutingModule} from "./account.routing.module";
import {SharedModule} from "../shared/shared.module";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {LoginComponent} from "./login/login.component";
import {AccountComponent} from "./account.component";
import {AccountCardComponent} from "./account-card.component";

@NgModule({
  imports: [
    AccountRoutingModule,
    CommonModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    AccountComponent,
    RegisterComponent,
    LoginComponent,
    AccountCardComponent
  ],
  entryComponents: [
    AccountComponent,
    RegisterComponent,
    LoginComponent,
    AccountCardComponent
  ],
  providers: [
    AccountCardComponent
  ]
})
export class AccountModule {

}
