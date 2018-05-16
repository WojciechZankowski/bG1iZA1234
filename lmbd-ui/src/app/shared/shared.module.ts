import {NgModule} from "@angular/core";
import {PercentagePipe} from "./pipes/percentage.pipe";
import {MoneyPipe} from "./pipes/money.pipe";
import {DecimalPipe} from "./pipes/decimal.pipe";
import {TranslateModule} from "@ngx-translate/core";
import {HeaderComponent} from "./navigation/header.component";

@NgModule({
  imports: [],
  declarations: [
    PercentagePipe,
    MoneyPipe,
    DecimalPipe,
    HeaderComponent
  ],
  exports: [
    PercentagePipe,
    MoneyPipe,
    DecimalPipe,
    HeaderComponent,
    TranslateModule
  ]
})
export class SharedModule {
}
