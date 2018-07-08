import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {PrincipalService} from "./principal.service";

@Injectable()
export class UserRouteAccessService implements CanActivate {

  constructor(private router: Router,
              private principal: PrincipalService) {
  }

  canActivate(route: ActivatedRouteSnapshot,
              state: RouterStateSnapshot): boolean | Promise<boolean> {

    const authorities = route.data['authorities'];
    if (!authorities || authorities.length === 0) {
      return true;
    }

    return this.checkLogin(authorities, state.url);
  }

  checkLogin(authorities: string[], url: string): Promise<boolean> {
    const principal = this.principal;
    return Promise.resolve(principal.identity().then((account) => {

      if (account && principal.hasAnyAuthorityDirect(authorities)) {
        return true;
      }

      this.router.navigate(['account'].concat(['login']));

      return false;
    }));
  }
}
