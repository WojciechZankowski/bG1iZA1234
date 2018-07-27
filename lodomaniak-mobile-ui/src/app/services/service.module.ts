import { NgModule } from "@angular/core";
import { CoreModule } from "../core/core.module";
import { AuthService } from "./auth.service";
import { IceCreamShopService } from "./ice-cream-shop.service";
import { FlavorService } from "./flavor.service";

@NgModule({
  imports: [
    CoreModule,
  ],
  providers: [
    AuthService,
    IceCreamShopService,
    FlavorService
  ]
})
export class ServiceModule {
}
