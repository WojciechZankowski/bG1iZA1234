import {NgModule} from "@angular/core";
import {CoreModule} from "../core/core.module";
import {RegisterService} from "./register.service";
import {AuthService} from "./auth.service";
import {PrincipalService} from "./principal.service";
import {UserRouteAccessService} from "./user-route-access.service";
import {CompanyService} from "./company.service";
import {IceCreamShopService} from "./ice-cream-shop.service";

@NgModule({
  imports: [
    CoreModule
  ],
  declarations: [],
  providers: [
    AuthService,
    RegisterService,
    PrincipalService,
    UserRouteAccessService,
    CompanyService,
    IceCreamShopService
  ]
})
export class ServiceModule {
}
