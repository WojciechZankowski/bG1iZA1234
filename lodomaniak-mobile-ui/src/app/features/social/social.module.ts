import { NgModule } from "@angular/core";
import { SocialComponent } from "./social.component";
import { ServiceModule } from "../../services/service.module";

@NgModule({
  imports: [
    ServiceModule
  ],
  entryComponents: [
    SocialComponent
  ],
  declarations: [
    SocialComponent
  ],
  exports: [
    SocialComponent
  ]
})
export class SocialModule {
}
