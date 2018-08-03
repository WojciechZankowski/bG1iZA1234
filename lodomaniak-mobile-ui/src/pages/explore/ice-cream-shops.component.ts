import { Component, OnInit, ViewChild } from "@angular/core";
import { IceCreamShopService } from "../../app/services/ice-cream-shop.service";
import { PageRequest } from "../../app/model/page-request.model";
import { IceCreamShop } from "../../app/model/ice-cream-shop.model";
import { Events, Searchbar } from "ionic-angular";
import { CityService } from "../../app/services/city.service";

@Component({
  selector: 'ice-cream-shops',
  templateUrl: './ice-cream-shops.component.html',
})
export class IceCreamShopsComponent implements OnInit {

  public searchInput: string = '';
  public shouldShowCancel: boolean = true;

  public shops: IceCreamShop[] = [];

  public page: number = 0;
  public totalPage: number = 0;
  public size: number = 10;

  @ViewChild('searchbar') searchbar: Searchbar;

  constructor(private iceCreamService: IceCreamShopService,
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
    this.iceCreamService.getIceCreamShops(this.searchInput, city, new PageRequest(this.page, this.size))
      .subscribe((shops) => {
        this.shops = shops.content;
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
    this.iceCreamService.getIceCreamShops(this.searchInput, 'Wrocław', new PageRequest(this.page, this.size))
      .subscribe((shops) => {
        this.shops = this.shops.concat(shops.content);

        infiniteScroll.complete();
      })
  }

}
