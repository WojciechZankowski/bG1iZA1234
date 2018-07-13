import {Component, OnInit} from "@angular/core";
import {MatDialog} from "@angular/material";
import {AddEditShopsComponent} from "./add-edit-shops.component";
import {IceCreamShopService} from "../../services/ice-cream-shop.service";
import {IceCreamShop} from "../../model/ice-cream-shop.model";

@Component({
  templateUrl: './ice-cream-shops.component.html',
  styleUrls: ['./ice-cream-shops.component.scss']
})
export class IceCreamShopsComponent implements OnInit {

  public iceCreamShops: Array<IceCreamShop> = [];

  constructor(private dialog: MatDialog,
              private iceCreamShopService: IceCreamShopService) {
  }

  ngOnInit(): void {
    this.iceCreamShopService.getIceCreamShops()
      .subscribe((shops: Array<IceCreamShop>) => {
          this.iceCreamShops = shops;
      })
  }

  openAddEditDialog(): void {
    this.dialog.open(AddEditShopsComponent, {
      height: '80vh',
      width: '600px',
    })

  }

}
