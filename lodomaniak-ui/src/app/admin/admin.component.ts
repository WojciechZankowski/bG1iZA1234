import {Component} from "@angular/core";
import {NavBarItem} from "../shared/navigation/nav-bar.component";

const menuItems: Array<NavBarItem> = [
  {name: 'MENU.DASHBOARD', url: ''},
  {name: 'MENU.LOANS', url: '/loans'},
  {name: 'MENU.HISTORY', url: '/history'}
];

const profileItems: Array<NavBarItem> = [
  {name: 'MENU.PROFILE.SETTINGS', url: '/profile/settings'}
];

@Component({
  templateUrl: './admin.component.html'
})
export class AdminComponent {

  public readonly MENU_ITEMS = menuItems;
  public readonly PROFILE_ITEMS = profileItems;

  public readonly opened: boolean = true;

}
