import { AfterViewInit, Component, OnInit, ViewChild } from "@angular/core";
import { IceCreamShopService } from "../../app/services/ice-cream-shop.service";
import { PageRequest } from "../../app/model/page-request.model";
import { IceCreamShop } from "../../app/model/ice-cream-shop.model";
import { Searchbar } from "ionic-angular";

@Component({
  selector: 'ice-cream-shops',
  templateUrl: './ice-cream-shops.component.html',
})
export class IceCreamShopsComponent implements OnInit, AfterViewInit {

  public searchInput: string = '';
  public shouldShowCancel: boolean = true;

  public shops: IceCreamShop[] = [];

  public page: number = 0;
  public totalPage: number = 0;
  public size: number = 10;

  @ViewChild('searchbar') searchbar: Searchbar;

  constructor(private iceCreamService: IceCreamShopService) {
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
    this.iceCreamService.getIceCreamShops(this.searchInput, 'Wrocław', new PageRequest(this.page, this.size))
      .subscribe((shops) => {
        this.shops = shops.content;
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
    this.iceCreamService.getIceCreamShops(this.searchInput, 'Wrocław', new PageRequest(this.page, this.size))
      .subscribe((shops) => {
        this.shops = this.shops.concat(shops.content);

        infiniteScroll.complete();
      })
  }

}
