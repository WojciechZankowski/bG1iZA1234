import {Component} from "@angular/core";
import {Credentials} from "../../model/credentials.model";
import {AuthService} from "../../services/auth.service";

@Component({
  templateUrl: './login.component.html'
})
export class LoginComponent {

  public credentials: Credentials = new Credentials();

  constructor(private authService: AuthService) {
  }

  public login(): void {
    this.credentials.rememberMe = true;
    this.authService.login(this.credentials).subscribe(result => {
      console.log(result);
    });
  }

}
