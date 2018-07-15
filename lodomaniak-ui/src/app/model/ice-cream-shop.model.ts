import {Address} from "./address.model";
import {Company} from "./company.model";
import {OpeningHoursRange} from "./opening-hours-range.model";

export class IceCreamShop {

  id: number;
  imageUrl: string;
  company: Company;
  address: Address;
  openingHours: { [key: string]: OpeningHoursRange };

  constructor(id: number, imageUrl: string, company: Company, address: Address, openingHours: { [key: string]: OpeningHoursRange }) {
    this.id = id;
    this.imageUrl = imageUrl;
    this.company = company;
    this.address = address;
    this.openingHours = openingHours;
  }
}
