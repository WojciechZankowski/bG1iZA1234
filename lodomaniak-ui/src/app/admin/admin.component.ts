import {Component} from "@angular/core";
import {NavBarItem} from "../shared/navigation/nav-bar.component";

const menuItems: Array<NavBarItem> = [
  {name: 'MENU.ICE_CREAM_SHOP', url: '/shops'},
  {name: 'MENU.FLAVORS', url: '/flavors'},
  {name: 'MENU.FLAVOR_SCHEDULER', url: '/flavor-scheduler'}
];

const profileItems: Array<NavBarItem> = [
  {name: 'MENU.PROFILE.SETTINGS', url: '/profile/settings'}
];

@Component({
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent {

  public readonly MENU_ITEMS = menuItems;
  public readonly PROFILE_ITEMS = profileItems;

  public readonly opened: boolean = true;

  public routerActiveOptions = {exact: true};

}
