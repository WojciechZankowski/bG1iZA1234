import {NgModule} from "@angular/core";
import {DashboardModule} from "./dashboard/dashboard.module";
import {PriceBarModule} from "./price-bar/price-bar.module";
import {LoansModule} from "./loans/loans.module";
import {HistoryModule} from "./history/history.module";

@NgModule({
  imports: [
    DashboardModule,
    PriceBarModule,
    HistoryModule,
    LoansModule
  ],
  exports: [
    DashboardModule,
    PriceBarModule,
    HistoryModule,
    LoansModule
  ]
})
export class FeaturesModule {

}
