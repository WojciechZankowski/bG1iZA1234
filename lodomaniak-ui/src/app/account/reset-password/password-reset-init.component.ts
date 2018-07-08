import {Component} from "@angular/core";
import {AuthService} from "../../services/auth.service";

@Component({
  templateUrl: './password-reset-init.component.html',
  styleUrls: ['./password-reset-init.component.scss']
})
export class PasswordResetInitComponent {

  public title: string = 'ACCOUNT.FORM.PASSWORD_RESET.TITLE';

  public email: string;

  constructor(private authService: AuthService) {
  }

  public passwordReset(): void {
  }

}
