import { Component, OnInit } from "@angular/core";
import { Events, NavController } from "ionic-angular";
import { Facebook, FacebookLoginResponse } from "@ionic-native/facebook";
import { AuthService } from "../../app/services/auth.service";
import { FacebookLogin } from "../../app/model/facebook-login.model";
import { JwtHelperService } from "@auth0/angular-jwt";
import { Storage } from "@ionic/storage";

@Component({
  templateUrl: './profile.component.html'
})
export class ProfilePage implements OnInit {

  public static readonly LOGIN_KEY = 'login';

  public logged: boolean = false;

  constructor(public navCtrl: NavController,
              private authService: AuthService,
              private fb: Facebook,
              private storage: Storage,
              public jwtHelper: JwtHelperService,
              public events: Events) {
  }

  ngOnInit(): void {
    this.checkIfLogged();
  }

  signIn(): void {
    console.log('test');
    this.fb.login(['public_profile', 'email'])
      .then((res: FacebookLoginResponse) => {
        console.log(res);
        this.authService.login(new FacebookLogin(res.authResponse.accessToken))
          .subscribe(() => {
            this.logged = true;
            this.events.publish(ProfilePage.LOGIN_KEY, '');
          })
      })
      .catch(e => console.log('Error logging into Facebook', e));
  }

  checkIfLogged(): void {
    this.storage.get(AuthService.TOKEN_KEY)
      .then((token) => {
        this.logged = !this.jwtHelper.isTokenExpired(token);
      })
  }

}
