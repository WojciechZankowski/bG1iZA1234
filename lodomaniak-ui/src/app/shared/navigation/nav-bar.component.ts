import { Component, Input } from '@angular/core';

export interface NavBarItem {
  name: string;
  url: string;
}

@Component({
  selector: 'lodomaniak-navbar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss'],
})
export class NavBarComponent {

  @Input()
  public profileItems: NavBarItem[] = [];

  @Input()
  public menuItems: NavBarItem[] = [];

  public profilePath = '/profile';
  public routerActiveOptions = { exact: true };

}
