import { Component, EventEmitter, OnInit, Output } from "@angular/core";
import { IceCreamShopService } from "../../app/services/ice-cream-shop.service";
import { Events, NavController } from "ionic-angular";
import { IceCreamShopsComponent } from "./ice-cream-shops.component";
import { CityService } from "../../app/services/city.service";
import { SelectSearchableComponent } from "ionic-select-searchable";

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent implements OnInit {

  public cities: string[] = [];
  public selectedCity: string;

  constructor(public navCtrl: NavController,
              private iceCreamService: IceCreamShopService,
              private cityService: CityService,
              public events: Events) {
  }

  ngOnInit(): void {
    this.iceCreamService.getCities().subscribe((cities) => {
      this.cities = cities;
    });
    this.cityService.getCity()
      .then((city) => {
        this.selectedCity = city;
      })
  }

  public onClick(): void {
    this.navCtrl.push(IceCreamShopsComponent);
  }

  cityChange(event: { component: SelectSearchableComponent, value: any }) {
    const city = event.value;
    this.cityService.citySelected(city);
    console.log(city);
    this.events.publish(CityService.CITY_KEY, city);
  }

}
