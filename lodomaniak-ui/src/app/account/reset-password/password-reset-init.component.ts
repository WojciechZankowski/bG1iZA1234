import {Component} from "@angular/core";
import {AuthService} from "../../services/auth.service";
import {RegisterService} from "../../services/register.service";
import {MatSnackBar} from "@angular/material";
import {TranslateService} from "@ngx-translate/core";

@Component({
  templateUrl: './password-reset-init.component.html',
  styleUrls: ['./password-reset-init.component.scss']
})
export class PasswordResetInitComponent {

  public title: string = 'ACCOUNT.FORM.PASSWORD_RESET.TITLE';

  public email: string;

  constructor(private registerService: RegisterService,
              private snackBar: MatSnackBar,
              private translateService: TranslateService) {
  }

  public passwordReset(): void {
    this.registerService.initPasswordReset(this.email).subscribe(() => {
      this.email = null;
      this.snackBar.open(
        this.translateService.instant('ACCOUNT.FORM.PASSWORD_RESET.INIT_SUCCESS'),
        this.translateService.instant('ACCOUNT.FORM.PASSWORD_RESET.CLOSE'));
    });
  }

}
