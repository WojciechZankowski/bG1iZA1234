import {NgModule} from "@angular/core";
import {PriceBarService} from "./price-bar.service";
import {CoreModule} from "../core/core.module";
import {RegisterService} from "./register.service";
import {AuthService} from "./auth.service";

@NgModule({
  imports: [
    CoreModule
  ],
  declarations: [],
  providers: [
    AuthService,
    PriceBarService,
    RegisterService
  ]
})
export class ServiceModule {
}
