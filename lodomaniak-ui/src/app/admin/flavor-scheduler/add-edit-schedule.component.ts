import { Component, Inject, OnInit } from '@angular/core';
import {
  DateAdapter,
  MAT_DATE_LOCALE,
  MAT_DIALOG_DATA,
  NativeDateAdapter,
} from '@angular/material';

import { FlavorSchedule } from '../../model/flavor-schedule.model';
import { IceCreamShop } from '../../model/ice-cream-shop.model';
import { IceCreamShopService } from '../../services/ice-cream-shop.service';
import { FlavorService } from '../../services/flavor.service';
import { Flavor } from '../../model/flavor.model';
import { PageRequest } from '../../model/page-request.model';

@Component({
  templateUrl: './add-edit-schedule.component.html',
  providers: [
    { provide: MAT_DATE_LOCALE, useValue: 'pl-PL' },
    { provide: DateAdapter, useClass: NativeDateAdapter },
  ],
})
export class AddEditScheduleComponent implements OnInit {

  public flavorSchedule: FlavorSchedule;
  public iceCreamShopList: IceCreamShop[] = [];
  public flavorList: Flavor[] = [];

  private edit: boolean = false;

  constructor(private iceCreamShopService: IceCreamShopService,
              private flavorService: FlavorService,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit(): void {
    const pageRequest = new PageRequest(0, 10000);
    this.flavorService.getFlavors(pageRequest).subscribe((flavors) => {
      this.flavorList = flavors.content;
    });

    this.iceCreamShopService.getIceCreamShops().subscribe((iceCreamShopList) => {
      this.iceCreamShopList = iceCreamShopList;
    });

    if (this.data != null) {
      this.flavorSchedule = this.data.flavorSchedule;
      this.edit = true;
    }

    if (!this.flavorSchedule) {
      this.flavorSchedule = new FlavorSchedule();
    }
  }

  save(): void {
    if (this.edit) {
      this.flavorService.updateSchedule(this.flavorSchedule).subscribe(() => {
      });
    } else {
      this.flavorService.saveSchedule(this.flavorSchedule).subscribe(() => {
      });
    }
  }

  compareShopsById(obj1: IceCreamShop, obj2: IceCreamShop): boolean {
    return obj1 && obj2 ? obj1.id === obj2.id : false;
  }

  compareFlavorsById(obj1: Flavor, obj2: Flavor): boolean {
    return obj1 && obj2 ? obj1.id === obj2.id : false;
  }

}
