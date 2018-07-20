import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material';
import { TranslateService } from '@ngx-translate/core';

import { Account } from '../../model/account.model';
import { RegisterService } from '../../services/register.service';
import { LOGIN_PATH, ROUTER_ACTIVE_OPTIONS } from '../../core/path.utilities';

@Component({
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {

  public readonly loginPath = LOGIN_PATH;
  public readonly routerActiveOptions = ROUTER_ACTIVE_OPTIONS;
  public readonly TITLE: string = 'ACCOUNT.FORM.REGISTER.TITLE';

  public account: Account = new Account();
  public confirmPassword: string;

  constructor(private registerService: RegisterService,
              private snackBar: MatSnackBar,
              private translateService: TranslateService) {
  }

  register() {
    if (this.account.password !== this.confirmPassword) {
      this.snackBar.open(
        this.translateService.instant('ACCOUNT.FORM.REGISTER.ERROR_PASSWORD'),
        this.translateService.instant('ACCOUNT.FORM.REGISTER.CLOSE'));
    } else {
      this.account.langKey = 'pl';
      this.registerService.save(this.account)
        .subscribe(
          (result) => {
            this.account = new Account();
            this.confirmPassword = null;
            this.snackBar.open(
              this.translateService.instant('ACCOUNT.FORM.REGISTER.SUCCESS'),
              this.translateService.instant('ACCOUNT.FORM.REGISTER.CLOSE'));
          },
          (error) => {
            this.snackBar.open(
              this.translateService.instant('ACCOUNT.FORM.REGISTER.ERROR'),
              this.translateService.instant('ACCOUNT.FORM.REGISTER.CLOSE'));
          });
    }
  }

}
