import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";

import {PriceBarComponent} from "./price-bar.component";
import {PriceBarItemComponent} from "./price-bar-item.component";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    SharedModule,
    BrowserModule
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
