import { Injectable } from "@angular/core";
import { ApiService } from "../core/api.service";
import { Social } from "../model/social.model";
import { Observable } from "rxjs/Observable";

@Injectable()
export class SocialService {

  constructor(private apiService: ApiService) {}

  getProviderSetting(provider) {
    switch (provider) {
      case 'google': return 'https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email';
      case 'facebook': return 'public_profile,email';
      case 'twitter': return '';
      default: return 'Provider setting not defined';
    }
  }

  getProviderURL(provider) {
    return '/signin/' + provider;
  }

  signIn(provider: string, social: Social): Observable<any> {
    return this.apiService.post(this.getProviderURL(provider), social);
  }

}
