import { NgModule } from "@angular/core";
import { SocialService } from "./social.service";
import { CsrfService } from "./csrf.service";
import { CoreModule } from "../core/core.module";
import { CookieModule } from "ngx-cookie";

@NgModule({
  imports: [
    CoreModule,
    CookieModule,
    CookieModule.forChild()
  ],
  providers: [
    SocialService,
    CsrfService,
  ]
})
export class ServiceModule {
}
