import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material';

import { AddEditFlavorComponent } from './add-edit-flavor.component';
import { Flavor } from '../../model/flavor.model';

@Component({
  selector: 'flavor-card',
  templateUrl: './flavor-card.component.html',
})
export class FlavorCardComponent {

  public readonly SELECTABLE = true;
  public readonly REMOVABLE = false;
  
  @Input()
  public flavor: Flavor;

  constructor(private dialog: MatDialog) {
  }

  edit(): void {
    this.dialog.open(AddEditFlavorComponent, {
      height: '50vh',
      width: '600px',
      data: {
        flavor: this.flavor,
      },
    });
  }

  getFilePath(name: string) {
    return '/assets/img/content/' + name;
  }

}
