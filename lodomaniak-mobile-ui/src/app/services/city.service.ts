import { Injectable } from "@angular/core"
import { Storage } from "@ionic/storage";

@Injectable()
export class CityService {

  public static readonly CITY_KEY = "city";

  constructor(private storage: Storage) {
  }

  citySelected(city: string): void {
    this.storage.set(CityService.CITY_KEY, city);
  }

  getCity(): Promise<string> {
    return this.storage.get(CityService.CITY_KEY);
  }

}
