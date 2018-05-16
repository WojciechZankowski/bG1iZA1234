import {NgModule} from "@angular/core";
import {PriceBarService} from "./price-bar.service";
import {CoreModule} from "../core/core.module";

@NgModule({
  imports: [
    CoreModule
  ],
  declarations: [],
  providers: [
    PriceBarService
  ]
})
export class ServiceModule {
}
