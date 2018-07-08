import {Component} from "@angular/core";
import {Account} from "../../model/account.model";
import {RegisterService} from "../../services/register.service";

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

  constructor(private registerService: RegisterService) {
  }

  register() {
    if (this.account.password !== this.confirmPassword) {
      console.log('gOWNO');
    } else {
      this.account.langKey = "pl";
      this.registerService.save(this.account)
        .subscribe((result) => {
        });
    }
  }

}
