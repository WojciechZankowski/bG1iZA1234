import {Component} from "@angular/core";
import {Account} from "../../model/account.model";
import {RegisterService} from "../../services/register.service";
import {MatSnackBar} from "@angular/material";
import {TranslateService} from "@ngx-translate/core";

@Component({
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  public title: string = 'ACCOUNT.FORM.REGISTER.TITLE';

  public account: Account = new Account();
  public confirmPassword: string;

  public loginPath = '/account/login';
  public routerActiveOptions = {exact: true};

  constructor(private registerService: RegisterService,
              private snackBar: MatSnackBar,
              private translateService: TranslateService) {
  }

  register() {
    if (this.account.password !== this.confirmPassword) {
      console.log('gOWNO');
    } else {
      this.account.langKey = "pl";
      this.registerService.save(this.account)
        .subscribe((result) => {
          this.account = new Account();
          this.confirmPassword = null;
          this.snackBar.open(
            this.translateService.instant('ACCOUNT.FORM.REGISTER.SUCCESS'),
            this.translateService.instant('ACCOUNT.FORM.REGISTER.CLOSE'));
        });
    }
  }

}
