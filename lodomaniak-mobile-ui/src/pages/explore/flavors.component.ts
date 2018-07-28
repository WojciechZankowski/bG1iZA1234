import { AfterViewInit, Component, OnInit, ViewChild } from "@angular/core";
import { PageRequest } from "../../app/model/page-request.model";
import { FlavorService } from "../../app/services/flavor.service";
import { Flavor } from "../../app/model/flavor.model";
import { Searchbar } from "ionic-angular";

@Component({
  selector: 'flavors',
  templateUrl: './flavors.component.html'
})
export class FlavorsComponent implements OnInit, AfterViewInit {

  public searchInput: string = '';
  public shouldShowCancel: boolean = true;

  public flavors: Flavor[] = [];

  public page: number = 0;
  public totalPage: number = 0;
  public size: number = 10;

  @ViewChild('searchbar') searchbar: Searchbar;

  constructor(private flavorService: FlavorService) {
  }

  ngOnInit(): void {
    this.fetchData();
    this.searchbar.setFocus();
  }

  ngAfterViewInit(): void {
    this.searchbar.setFocus();
  }

  private fetchData(): void {
    this.page = 0;
    this.flavorService.getFlavors(this.searchInput, 'Wrocław', new PageRequest(this.page, this.size))
      .subscribe((shops) => {
        this.flavors = shops.content;
        this.totalPage = shops.totalPages;
      })
  }

  public onInput(): void {
    this.fetchData();
  }

  public onCancel(): void {
    this.searchInput = '';
    this.fetchData();
  }

  public doInfinite(infiniteScroll) {
    this.page = this.page + 1;
    this.flavorService.getFlavors(this.searchInput, 'Wrocław', new PageRequest(this.page, this.size))
      .subscribe((shops) => {
        this.flavors = this.flavors.concat(shops.content);

        infiniteScroll.complete();
      })
  }

}
