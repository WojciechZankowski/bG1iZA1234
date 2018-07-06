import {NgModule} from "@angular/core";

import {PriceBarComponent} from "./price-bar.component";
import {PriceBarItemComponent} from "./price-bar-item.component";
import {SharedModule} from "../../shared/shared.module";
import {BrowserModule} from "@angular/platform-browser";

@NgModule({
  imports: [
    BrowserModule,
    SharedModule
  ],
  declarations: [
    PriceBarComponent,
    PriceBarItemComponent,
  ],
  exports: [
    PriceBarComponent
  ],
  entryComponents: [],
  providers: []
})
export class PriceBarModule {
}
