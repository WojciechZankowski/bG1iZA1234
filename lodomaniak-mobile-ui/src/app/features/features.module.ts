import { NgModule } from "@angular/core";
import { SocialModule } from "./social/social.module";

@NgModule({
  imports: [
    SocialModule
  ],
  exports: [
    SocialModule
  ]
})
export class FeaturesModule {

}
