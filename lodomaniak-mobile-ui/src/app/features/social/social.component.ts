import { Component, Input, OnInit } from "@angular/core";
import { SocialService } from "../../services/social.service";
import { CsrfService } from "../../services/csrf.service";
import { Social } from "../../model/social.model";

@Component({
  selector: 'lodomaniak-social',
  templateUrl: './social.component.html',
})
export class SocialComponent implements OnInit {
  @Input() provider: string;
  label: string;
  providerSetting: string;
  providerURL: string;
  csrf: string;

  constructor(
    private csrfService: CsrfService,
    private socialService: SocialService
  ) {
  }

  ngOnInit() {
    this.label = this.provider.charAt(0).toUpperCase() + this.provider.slice(1);
    this.providerSetting = this.socialService.getProviderSetting(this.provider);
    this.providerURL = this.socialService.getProviderURL(this.provider);
    this.csrf = this.csrfService.getCSRF();
  }

  signIn(): void {
    this.socialService.signIn(this.provider, new Social(this.providerSetting, this.csrf))
      .subscribe(() => {
      });
  }

}
