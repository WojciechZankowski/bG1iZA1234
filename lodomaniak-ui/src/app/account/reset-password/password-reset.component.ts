import { MatSnackBar } from '@angular/material';
import { TranslateService } from '@ngx-translate/core';
import { filter } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

import { PasswordReset } from '../../model/password-reset.model';
import { RegisterService } from '../../services/register.service';
import { LOGIN_PATH, ROUTER_ACTIVE_OPTIONS } from '../../core/path.utilities';

@Component({
  templateUrl: './password-reset.component.html',
  styleUrls: ['./password-reset.component.scss'],
})
export class PasswordResetComponent implements OnInit {

  public readonly TITLE: string = 'ACCOUNT.FORM.PASSWORD_RESET.TITLE';
  public readonly loginPath = LOGIN_PATH;
  public readonly routerActiveOptions = ROUTER_ACTIVE_OPTIONS;

  public resetModel: PasswordReset = new PasswordReset();
  public confirmPassword: string;

  constructor(private route: ActivatedRoute,
              private registerService: RegisterService,
              private snackBar: MatSnackBar,
              private translateService: TranslateService) {
  }

  ngOnInit(): void {
    this.route.queryParams
      .pipe(filter(params => params.key))
      .subscribe((params) => {
        this.resetModel.key = params.key;
      });
  }

  public passwordReset(): void {
    if (this.resetModel.password !== this.confirmPassword) {
      this.snackBar.open(
        this.translateService.instant('ACCOUNT.FORM.PASSWORD_RESET.ERROR_PASSWORD'),
        this.translateService.instant('ACCOUNT.FORM.PASSWORD_RESET.CLOSE'));
    } else {
      this.registerService.passwordReset(this.resetModel)
        .subscribe(() => {
          this.resetModel = new PasswordReset();
          this.confirmPassword = null;
          this.snackBar.open(
            this.translateService.instant('ACCOUNT.FORM.PASSWORD_RESET.SUCCESS'),
            this.translateService.instant('ACCOUNT.FORM.PASSWORD_RESET.CLOSE'));
        });
    }
  }

}
