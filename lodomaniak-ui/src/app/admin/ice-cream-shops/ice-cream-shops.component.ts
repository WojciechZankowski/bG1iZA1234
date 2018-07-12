import {Component} from "@angular/core";
import {MatDialog} from "@angular/material";
import {AddEditShopsComponent} from "./add-edit-shops.component";

@Component({
  templateUrl: './ice-cream-shops.component.html'
})
export class IceCreamShopsComponent {

  constructor(private dialog: MatDialog) {
  }

  openAddEditDialog(): void {
    this.dialog.open(AddEditShopsComponent, {
      height: '80vh',
      width: '600px',
    })

  }

}
