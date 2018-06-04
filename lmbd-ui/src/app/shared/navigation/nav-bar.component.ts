import {Component, Input} from "@angular/core";
import {Router} from "@angular/router";

export interface NavBarItem {
  name: string;
  url: string;
}

@Component({
  selector: 'lmbd-navbar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent {

  @Input()
  public profileItems: Array<NavBarItem> = [];

  @Input()
  public menuItems: Array<NavBarItem> = [];

  public profilePath = '/profile';
  public routerActiveOptions = {exact: true};


}
