import {NgModule} from "@angular/core";
import {TranslateModule} from "@ngx-translate/core";

import {PercentagePipe} from "./pipes/percentage.pipe";
import {MoneyPipe} from "./pipes/money.pipe";
import {DecimalPipe} from "./pipes/decimal.pipe";
import {HeaderComponent} from "./navigation/header.component";
import {DesignModule} from "./design/design.module";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {NavBarComponent} from "./navigation/nav-bar.component";
import {RouterModule} from "@angular/router";
import {CommonModule} from "@angular/common";
import {SidenavComponent} from "./sidenav/sidenav.component";

@NgModule({
  imports: [
    CommonModule,
    DesignModule,
    TranslateModule,
    RouterModule
  ],
  declarations: [
    PercentagePipe,
    MoneyPipe,
    DecimalPipe,
    HeaderComponent,
    NavBarComponent,
    SidenavComponent
  ],
  exports: [
    PercentagePipe,
    MoneyPipe,
    DecimalPipe,
    CommonModule,
    HeaderComponent,
    NavBarComponent,
    SidenavComponent,
    TranslateModule,
    DesignModule,
    NgbModule
  ]
})
export class SharedModule {
}
