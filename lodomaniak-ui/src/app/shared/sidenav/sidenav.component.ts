import { Component, Input } from '@angular/core';

import { NavBarItem } from '../navigation/nav-bar.component';

@Component({
  selector: 'lodomaniak-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.scss'],
})
export class SidenavComponent {

  @Input()
  public menuItems: NavBarItem[] = [];

  public readonly routerActiveOptions = { exact: true };
  public readonly opened: boolean = true;

}
