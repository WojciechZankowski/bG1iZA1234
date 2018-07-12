import {NgModule} from "@angular/core";
import {AddEditShopsComponent} from "./add-edit-shops.component";
import {IceCreamShopsComponent} from "./ice-cream-shops.component";
import {SharedModule} from "../../shared/shared.module";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    SharedModule,
    FormsModule
  ],
  declarations: [
    AddEditShopsComponent,
    IceCreamShopsComponent
  ],
  entryComponents: [
    AddEditShopsComponent,
    IceCreamShopsComponent
  ]
})
export class IceCreamShopsModule {

}
