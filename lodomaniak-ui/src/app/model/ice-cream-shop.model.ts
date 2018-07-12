import {Address} from "./address.model";
import {Company} from "./company.model";
import {OpeningHours} from "./opening-hours.model";

export class IceCreamShop {

  company: Company;
  address: Address;
  openingHours: OpeningHours;

  constructor(company: Company, address: Address, openingHours: OpeningHours) {
    this.company = company;
    this.address = address;
    this.openingHours = openingHours;
  }
}
