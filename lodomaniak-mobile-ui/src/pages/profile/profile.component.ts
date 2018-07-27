import { Component } from "@angular/core";
import { NavController } from "ionic-angular";
import { Facebook, FacebookLoginResponse } from "@ionic-native/facebook";
import { AuthService } from "../../app/services/auth.service";
import { FacebookLogin } from "../../app/model/facebook-login.model";

@Component({
  templateUrl: './profile.component.html'
})
export class ProfilePage {

  constructor(public navCtrl: NavController,
              private authService: AuthService,
              private fb: Facebook) {
  }

  signIn(): void {
    this.fb.login(['public_profile', 'email'])
      .then((res: FacebookLoginResponse) => {
        this.authService.login(new FacebookLogin(res.authResponse.accessToken))
      })
      .catch(e => console.log('Error logging into Facebook', e));
  }

}
