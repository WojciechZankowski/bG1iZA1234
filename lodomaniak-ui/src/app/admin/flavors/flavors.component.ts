import {Component, OnInit} from "@angular/core";
import {MatDialog} from "@angular/material";
import {FlavorService} from "../../services/flavor.service";
import {AddEditFlavorComponent} from "./add-edit-flavor.component";
import {Flavor} from "../../model/flavor.model";

@Component({
  templateUrl: './flavors.component.html',
  styleUrls: ['./flavors.component.scss']
})
export class FlavorsComponent implements OnInit {

  public flavors: Array<Flavor> = [];

  constructor(private dialog: MatDialog,
              private flavorService: FlavorService) {
  }

  ngOnInit(): void {
    this.fetchFlavors();
  }

  fetchFlavors(): void {
    this.flavorService.getFlavors()
      .subscribe((flavors) => {
        this.flavors = flavors;
      })
  }

  openAddEditDialog(): void {
    let matDialogRef = this.dialog.open(AddEditFlavorComponent, {
      height: '50vh',
      width: '600px',
    });

    matDialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.fetchFlavors();
      }
    });

  }

}
