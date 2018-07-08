import {Component, OnInit} from "@angular/core";
import {Account} from "../../model/account.model";
import {PasswordReset} from "../../model/password-reset.model";
import {filter} from "rxjs/operators";
import {ActivatedRoute} from "@angular/router";
import {RegisterService} from "../../services/register.service";
import {MatSnackBar} from "@angular/material";
import {TranslateService} from "@ngx-translate/core";

@Component({
  templateUrl: './password-reset.component.html',
  styleUrls: ['./password-reset.component.scss']
})
export class PasswordResetComponent implements OnInit{

  public title: string = 'ACCOUNT.FORM.PASSWORD_RESET.TITLE';

  public resetModel: PasswordReset = new PasswordReset();
  public confirmPassword: string;

  public loginPath = '/account/login';
  public routerActiveOptions = {exact: true};

  constructor(private route: ActivatedRoute,
              private registerService: RegisterService,
              private snackBar: MatSnackBar,
              private translateService: TranslateService) {}

  ngOnInit(): void {
    this.route.queryParams
      .pipe(filter(params => params.key))
      .subscribe(params => {
        console.log(params.key);

        this.resetModel.key = params.key;
      })
  }

  public passwordReset(): void {
    if (this.resetModel.password !== this.confirmPassword) {
      console.log('gOWNO');
    } else {
      this.registerService.passwordReset(this.resetModel)
        .subscribe(() => {
          this.resetModel = new PasswordReset();
          this.confirmPassword = null;
          this.snackBar.open(
            this.translateService.instant('ACCOUNT.FORM.PASSWORD_RESET.SUCCESS'),
            this.translateService.instant('ACCOUNT.FORM.PASSWORD_RESET.CLOSE'));
        })
    }
  }


}
