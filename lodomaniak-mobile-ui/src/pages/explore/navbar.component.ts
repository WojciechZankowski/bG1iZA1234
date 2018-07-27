import { Component, OnInit } from "@angular/core";
import { IceCreamShopService } from "../../app/services/ice-cream-shop.service";

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent implements OnInit {

  public cities: string[] = [];
  public selectedCity: string;

  constructor(private iceCreamService: IceCreamShopService) {
  }

  ngOnInit(): void {
    this.iceCreamService.getCities().subscribe((cities) => {
      this.cities = cities;
    })
  }

}
