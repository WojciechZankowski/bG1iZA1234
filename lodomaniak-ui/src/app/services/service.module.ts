import {NgModule} from "@angular/core";
import {PriceBarService} from "./price-bar.service";
import {CoreModule} from "../core/core.module";
import {RegisterService} from "./register.service";
import {AuthService} from "./auth.service";
import {PrincipalService} from "./principal.service";
import {UserRouteAccessService} from "./user-route-access.service";
import {CompanyService} from "./company.service";

@NgModule({
  imports: [
    CoreModule
  ],
  declarations: [],
  providers: [
    AuthService,
    PriceBarService,
    RegisterService,
    PrincipalService,
    UserRouteAccessService,
    CompanyService
  ]
})
export class ServiceModule {
}
