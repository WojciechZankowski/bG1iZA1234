import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';

import { AddEditShopsComponent } from './add-edit-shops.component';
import { IceCreamShopService } from '../../services/ice-cream-shop.service';
import { IceCreamShop } from '../../model/ice-cream-shop.model';

@Component({
  templateUrl: './ice-cream-shops.component.html',
  styleUrls: ['./ice-cream-shops.component.scss'],
})
export class IceCreamShopsComponent implements OnInit {

  public iceCreamShops: IceCreamShop[] = [];

  constructor(private dialog: MatDialog,
              private iceCreamShopService: IceCreamShopService) {
  }

  ngOnInit(): void {
    this.fetchShops();
  }

  fetchShops() {
    this.iceCreamShopService.getIceCreamShops()
      .subscribe((shops: IceCreamShop[]) => {
        this.iceCreamShops = shops;
      });
  }

  openAddEditDialog(): void {
    const matDialogRef = this.dialog.open(AddEditShopsComponent, {
      height: '80vh',
      width: '600px',
    });

    matDialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.fetchShops();
      }
    });
  }

}
