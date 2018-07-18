import { NgModule } from '@angular/core';

import { AdminRoutingModule } from './admin.routing.module';
import { AdminComponent } from './admin.component';
import { SharedModule } from '../shared/shared.module';
import { IceCreamShopsModule } from './ice-cream-shops/ice-cream-shops.module';
import { FlavorsModule } from './flavors/flavors.module';
import { FlavorSchedulerModule } from './flavor-scheduler/flavor-scheduler.module';

@NgModule({
  imports: [
    AdminRoutingModule,
    IceCreamShopsModule,
    FlavorsModule,
    FlavorSchedulerModule,
    SharedModule,
  ],
  declarations: [
    AdminComponent,
  ],
  entryComponents: [
    AdminComponent,
  ],
})
export class AdminModule {

}
