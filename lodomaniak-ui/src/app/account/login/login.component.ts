import {Component, OnInit} from "@angular/core";
import {Credentials} from "../../model/credentials.model";
import {AuthService} from "../../services/auth.service";
import {PrincipalService} from "../../services/principal.service";
import {Router} from "@angular/router";

@Component({
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public credentials: Credentials = new Credentials();
  public title: string = 'ACCOUNT.FORM.LOGIN.TITLE';

  public registrationPath = '/account/register';
  public passwordResetPath = '/account/password-reset';
  public routerActiveOptions = {exact: true};

  constructor(private router: Router,
              private authService: AuthService,
              private principal: PrincipalService) {
  }

  ngOnInit(): void {
  }

  public login(): void {
    this.credentials.rememberMe = false;
    this.authService.login(this.credentials).subscribe(result => {
      this.principal.identity(true).then((account) => {
        this.router.navigate(['']);
      });
    });
  }

}
