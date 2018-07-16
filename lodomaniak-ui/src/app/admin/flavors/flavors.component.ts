import {Component, OnInit} from "@angular/core";
import {MatDialog, PageEvent} from "@angular/material";
import {FlavorService} from "../../services/flavor.service";
import {AddEditFlavorComponent} from "./add-edit-flavor.component";
import {Flavor} from "../../model/flavor.model";
import {Page} from "../../model/page.model";
import {PageRequest} from "../../model/page-request.model";

@Component({
  templateUrl: './flavors.component.html',
  styleUrls: ['./flavors.component.scss']
})
export class FlavorsComponent implements OnInit {

  public flavors: Page<Flavor>;

  public length: number = 0;
  public pageSize: number = 25;
  public pageSizeOptions: Array<number> = [10, 25, 50];

  constructor(private dialog: MatDialog,
              private flavorService: FlavorService) {
  }

  ngOnInit(): void {
    this.fetchFlavors();
  }

  onPageChange(event: PageEvent): void {
    const pageRequest = new PageRequest(event.pageIndex, event.pageSize);
    this.flavorService.getFlavors(pageRequest)
      .subscribe((flavors) => {
        this.flavors = flavors;
      })
  }

  fetchFlavors(): void {
    const pageRequest = new PageRequest(0, this.pageSize);
    this.flavorService.getFlavors(pageRequest)
      .subscribe((flavors) => {
        this.flavors = flavors;
      })
  }

  openAddEditDialog(): void {
    let matDialogRef = this.dialog.open(AddEditFlavorComponent, {
      height: '50vh',
      width: '600px'
    });

    matDialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.fetchFlavors();
      }
    });

  }

}
