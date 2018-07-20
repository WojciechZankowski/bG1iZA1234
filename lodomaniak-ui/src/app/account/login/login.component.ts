import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';
import { TranslateService } from '@ngx-translate/core';

import { Credentials } from '../../model/credentials.model';
import { AuthService } from '../../services/auth.service';
import { PrincipalService } from '../../services/principal.service';
import {
  PASSWORD_RESET_PATH, REGISTER_PATH,
  ROUTER_ACTIVE_OPTIONS,
} from '../../core/path.utilities';

@Component({
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {

  public readonly TITLE: string = 'ACCOUNT.FORM.LOGIN.TITLE';
  public readonly registrationPath = REGISTER_PATH;
  public readonly passwordResetPath = PASSWORD_RESET_PATH;
  public readonly routerActiveOptions = ROUTER_ACTIVE_OPTIONS;

  public credentials: Credentials = new Credentials();

  constructor(private router: Router,
              private authService: AuthService,
              private snackBar: MatSnackBar,
              private translateService: TranslateService,
              private principal: PrincipalService) {
  }

  public login(): void {
    this.credentials.rememberMe = false;
    this.authService.login(this.credentials).subscribe(
      (result) => {
        this.principal.identity(true).then((account) => {
          this.router.navigate(['']);
        });
      },
      (error) => {
        this.snackBar.open(
          this.translateService.instant('ACCOUNT.FORM.LOGIN.ERROR'),
          this.translateService.instant('ACCOUNT.FORM.LOGIN.CLOSE'));
      });
  }

}
