import {Component, OnInit} from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import {NavBarItem} from "./shared/navigation/nav-bar.component";

const menuItems: Array<NavBarItem> = [
  {name: 'MENU.DASHBOARD', url: ''},
  {name: 'MENU.LOANS', url: '/loans'},
  {name: 'MENU.HISTORY', url: '/history'}
];

const profileItems: Array<NavBarItem> = [
  {name: 'MENU.PROFILE.SETTINGS', url: '/profile/settings'}
];

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  public readonly MENU_ITEMS = menuItems;
  public readonly PROFILE_ITEMS = profileItems;

  title = 'app';
  public readonly opened: boolean = true;

  constructor(private translateService: TranslateService) {
  }

  ngOnInit(): void {
    this.translateService.setDefaultLang('pl');
    this.translateService.use('pl');
  }

}
