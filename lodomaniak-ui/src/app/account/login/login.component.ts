import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Credentials } from '../../model/credentials.model';
import { AuthService } from '../../services/auth.service';
import { PrincipalService } from '../../services/principal.service';

@Component({
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {

  public credentials: Credentials = new Credentials();
  public title: string = 'ACCOUNT.FORM.LOGIN.TITLE';

  public registrationPath = '/account/register';
  public passwordResetPath = '/account/password-reset';
  public routerActiveOptions = { exact: true };

  constructor(private router: Router,
              private authService: AuthService,
              private principal: PrincipalService) {
  }

  public login(): void {
    this.credentials.rememberMe = false;
    this.authService.login(this.credentials).subscribe((result) => {
      this.principal.identity(true).then((account) => {
        this.router.navigate(['']);
      });
    });
  }

}
