import {Component} from "@angular/core";
import {Account} from "../../model/account.model";
import {RegisterService} from "../../services/register.service";

@Component({
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  public account: Account = new Account();
  public confirmPassword: string;

  constructor(private registerService: RegisterService) {
  }

  register() {
    if (this.account.password !== this.confirmPassword) {
      console.log('gOWNO');
    } else {
      this.registerService.save(this.account)
        .subscribe((result) => {
        });
    }
  }

}
