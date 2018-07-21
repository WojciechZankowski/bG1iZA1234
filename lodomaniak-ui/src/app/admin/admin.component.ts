import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { NavBarItem } from '../shared/navigation/nav-bar.component';
import { AuthService } from '../services/auth.service';

const menuItems: NavBarItem[] = [
  { icon: 'store', name: 'MENU.ICE_CREAM_SHOP', url: '/shops' },
  { icon: 'opacity', name: 'MENU.FLAVORS', url: '/flavors' },
  { icon: 'event', name: 'MENU.FLAVOR_SCHEDULER', url: '/flavor-scheduler' },
];

@Component({
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss'],
})
export class AdminComponent {

  public readonly MENU_ITEMS = menuItems;
  public readonly opened: boolean = true;

  public routerActiveOptions = { exact: true };

  constructor(private authService: AuthService,
              private router: Router) {
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['']);
  }

}
