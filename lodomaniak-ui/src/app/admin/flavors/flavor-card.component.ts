import {Component, Input} from "@angular/core";
import {MatDialog} from "@angular/material";
import {AddEditShopsComponent} from "../ice-cream-shops/add-edit-shops.component";
import {AddEditFlavorComponent} from "./add-edit-flavor.component";
import {Flavor} from "../../model/flavor.model";
import {COMMA, ENTER} from "@angular/cdk/keycodes";

@Component({
  selector: 'flavor-card',
  templateUrl: './flavor-card.component.html',
  styleUrls: ['./flavor-card.component.scss']
})
export class FlavorCardComponent {

  @Input()
  public flavor: Flavor;

  selectable = true;
  removable = false;

  constructor(private dialog: MatDialog) {}

  edit(): void {

    this.dialog.open(AddEditFlavorComponent, {
      height: '50vh',
      width: '600px',
      data: {
        flavor: this.flavor
      }
    });
  }

  getFilePath(name: string) {
    return '/assets/img/content/' + name;
  }

}
