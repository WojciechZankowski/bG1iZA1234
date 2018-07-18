import { NgModule } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule } from '@angular/forms';

import { AddEditFlavorComponent } from './add-edit-flavor.component';
import { FlavorsComponent } from './flavors.component';
import { SharedModule } from '../../shared/shared.module';
import { FlavorCardComponent } from './flavor-card.component';

@NgModule({
  imports:  [
    SharedModule,
    FormsModule,
    FlexLayoutModule,
  ],
  entryComponents: [
    FlavorsComponent,
    FlavorCardComponent,
    AddEditFlavorComponent,
  ],
  declarations: [
    FlavorsComponent,
    FlavorCardComponent,
    AddEditFlavorComponent,
  ],
})
export class FlavorsModule {

}
