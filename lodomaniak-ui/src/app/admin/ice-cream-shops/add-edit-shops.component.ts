import {Component, OnInit} from "@angular/core";
import {MatDialog} from "@angular/material";
import {IceCreamShop} from "../../model/ice-cream-shop.model";
import {Address} from "../../model/address.model";
import {OpeningHours} from "../../model/opening-hours.model";
import {Company} from "../../model/company.model";
import {OpeningHoursRange} from "../../model/opening-hours-range.model";
import {CompanyService} from "../../services/company.service";

@Component({
  templateUrl: './add-edit-shops.component.html',
  styleUrls: ['./add-edit-shops.component.scss']
})
export class AddEditShopsComponent implements OnInit {

  public companyList: Array<Company> = [];

  public iceCreamShop: IceCreamShop = new IceCreamShop(new Company(), new Address(), new OpeningHours());

  objectKeys = Object.keys;

  constructor(private companyService: CompanyService) {
  }

  ngOnInit(): void {
    let openingHours = {};
    openingHours['MONDAY'] = new OpeningHoursRange();
    openingHours['TUESDAY'] = new OpeningHoursRange();
    openingHours['WEDNESDAY'] = new OpeningHoursRange();
    openingHours['THURSDAY'] = new OpeningHoursRange();
    openingHours['FRIDAY'] = new OpeningHoursRange();
    openingHours['SATURDAY'] = new OpeningHoursRange();
    openingHours['SUNDAY'] = new OpeningHoursRange();

    this.companyService.getCompanies()
      .subscribe((companies: Array<Company>) => {
        this.companyList = companies;
      });

    this.iceCreamShop.openingHours.openingHours = openingHours;
  }


}
