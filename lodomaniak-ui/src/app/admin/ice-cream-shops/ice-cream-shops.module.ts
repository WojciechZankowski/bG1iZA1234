import {NgModule} from "@angular/core";
import {AddEditShopsComponent} from "./add-edit-shops.component";
import {IceCreamShopsComponent} from "./ice-cream-shops.component";
import {SharedModule} from "../../shared/shared.module";
import {FormsModule} from "@angular/forms";
import {IceCreamShopCardComponent} from "./ice-cream-shop-card.component";
import {FlexLayoutModule} from "@angular/flex-layout";

@NgModule({
  imports: [
    SharedModule,
    FormsModule,
    FlexLayoutModule
  ],
  declarations: [
    AddEditShopsComponent,
    IceCreamShopsComponent,
    IceCreamShopCardComponent
  ],
  entryComponents: [
    AddEditShopsComponent,
    IceCreamShopsComponent
  ]
})
export class IceCreamShopsModule {

}
