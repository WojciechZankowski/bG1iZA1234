import {Injectable} from "@angular/core";
import {RegisterService} from "./register.service";

@Injectable()
export class PrincipalService {

  private userIdentity: any;
  private authenticated = false;

  constructor(
    private accountService: RegisterService
  ) { }

  hasAnyAuthorityDirect(authorities: string[]): boolean {
    if (!this.authenticated || !this.userIdentity || !this.userIdentity.authorities) {
      return false;
    }

    for (let i = 0; i < authorities.length; i++) {
      if (this.userIdentity.authorities.indexOf(authorities[i]) !== -1) {
        return true;
      }
    }

    return false;
  }

  identity(force?: boolean): Promise<any> {
    if (force === true) {
      this.userIdentity = undefined;
    }

    if (this.userIdentity) {
      return Promise.resolve(this.userIdentity);
    }

    return this.accountService.get().toPromise().then((account) => {
      if (account) {
        this.userIdentity = account;
        this.authenticated = true;
      } else {
        this.userIdentity = null;
        this.authenticated = false;
      }
      return this.userIdentity;
    });
  }

}
