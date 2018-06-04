import {NgModule} from "@angular/core";
import {RegisterComponent} from "./register/register.component";
import {AccountRoutingModule} from "./account.routing.module";
import {SharedModule} from "../shared/shared.module";
import {CommonModule} from "@angular/common";

@NgModule({
  imports: [
    AccountRoutingModule,
    CommonModule,
    SharedModule
  ],
  declarations: [
    RegisterComponent
  ],
  entryComponents: [
    RegisterComponent
  ]
})
export class AccountModule {

}
