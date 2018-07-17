import {Component, Input} from "@angular/core";
import {IceCreamShop} from "../../model/ice-cream-shop.model";
import {MatDialog} from "@angular/material";
import {AddEditShopsComponent} from "./add-edit-shops.component";
import {environment} from "../../../environments/environment";
import {DayOfWeek} from "../../model/day-of-week.model";

@Component({
  selector: 'ice-cream-shop-card',
  templateUrl: './ice-cream-shop-card.component.html',
  styleUrls: ['./ice-cream-shop-card.component.scss']
})
export class IceCreamShopCardComponent {

  @Input()
  public iceCreamShop: IceCreamShop;

  public readonly DAY_OF_WEEK = Object.keys(DayOfWeek)
    .map(key => DayOfWeek[key])
    .filter(value => typeof value === 'string') as string[];

  constructor(private dialog: MatDialog) {}

  edit(): void {
    this.dialog.open(AddEditShopsComponent, {
      height: '80vh',
      width: '600px',
      data: {
        iceCreamShop: this.iceCreamShop
      }
    });
  }

  getFilePath(name: string) {
    return '/assets/img/content/' + name;
  }

}
