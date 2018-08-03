import { Component, OnInit, ViewChild } from "@angular/core";
import { PageRequest } from "../../app/model/page-request.model";
import { FlavorService } from "../../app/services/flavor.service";
import { Flavor } from "../../app/model/flavor.model";
import { Events, Searchbar } from "ionic-angular";
import { CityService } from "../../app/services/city.service";

@Component({
  selector: 'flavors',
  templateUrl: './flavors.component.html'
})
export class FlavorsComponent implements OnInit {

  public searchInput: string = '';
  public shouldShowCancel: boolean = true;

  public flavors: Flavor[] = [];

  public page: number = 0;
  public totalPage: number = 0;
  public size: number = 10;

  @ViewChild('searchbar') searchbar: Searchbar;

  constructor(private flavorService: FlavorService,
              private cityService: CityService,
              public events: Events) {
    this.events.subscribe(CityService.CITY_KEY, (city) => {
      this.fetchData(city);
    });
  }

  ngOnInit(): void {
    this.cityService.getCity()
      .then((city) => {
        this.fetchData(city);
      });
  }

  private fetchData(city: string): void {
    this.page = 0;
    this.flavorService.getFlavors(this.searchInput, city, new PageRequest(this.page, this.size))
      .subscribe((shops) => {
        this.flavors = shops.content;
        this.totalPage = shops.totalPages;
      })
  }

  public onInput(): void {
    this.cityService.getCity()
      .then((city) => {
        this.fetchData(city);
      });
  }

  public onCancel(): void {
    this.searchInput = '';
    this.cityService.getCity()
      .then((city) => {
        this.fetchData(city);
      });
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
