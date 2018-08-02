import { NgModule } from "@angular/core";
import { CoreModule } from "../core/core.module";
import { AuthService } from "./auth.service";
import { IceCreamShopService } from "./ice-cream-shop.service";
import { FlavorService } from "./flavor.service";
import { RatingService } from "./rating.service";
import { CityService } from "./city.service";

@NgModule({
  imports: [
    CoreModule,
  ],
  providers: [
    AuthService,
    IceCreamShopService,
    FlavorService,
    RatingService,
    CityService
  ]
})
export class ServiceModule {
}
