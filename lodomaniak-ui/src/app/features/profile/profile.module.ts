import {NgModule} from "@angular/core";
import {ProfileComponent} from "./profile.component";
import {ProfileSettingsComponent} from "./settings/profile-settings.component";
import {ProfileRoutingModule} from "./profile.routing.module";

@NgModule({
  imports: [
    ProfileRoutingModule
  ],
  entryComponents: [
    ProfileComponent,
    ProfileSettingsComponent
  ],
  declarations: [
    ProfileComponent,
    ProfileSettingsComponent
  ]
})
export class ProfileModule {

}
