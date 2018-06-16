import {NgModule} from "@angular/core";
import {RegisterComponent} from "./register/register.component";
import {AccountRoutingModule} from "./account.routing.module";
import {SharedModule} from "../shared/shared.module";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {LoginComponent} from "./login/login.component";

@NgModule({
  imports: [
    AccountRoutingModule,
    CommonModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    RegisterComponent,
    LoginComponent
  ],
  entryComponents: [
    RegisterComponent,
    LoginComponent
  ]
})
export class AccountModule {

}
