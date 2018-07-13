import {Component, OnInit} from "@angular/core";
import {MatDialog} from "@angular/material";
import {IceCreamShop} from "../../model/ice-cream-shop.model";
import {Address} from "../../model/address.model";
import {OpeningHours} from "../../model/opening-hours.model";
import {Company} from "../../model/company.model";
import {OpeningHoursRange} from "../../model/opening-hours-range.model";
import {CompanyService} from "../../services/company.service";
import {IceCreamShopService} from "../../services/ice-cream-shop.service";

@Component({
  templateUrl: './add-edit-shops.component.html',
  styleUrls: ['./add-edit-shops.component.scss']
})
export class AddEditShopsComponent implements OnInit {

  public companyList: Array<Company> = [];
  public iceCreamShop: IceCreamShop = new IceCreamShop(new Company(), new Address(), new OpeningHours());
  public objectKeys = Object.keys;

  constructor(private companyService: CompanyService,
              private iceCreamShopService: IceCreamShopService) {
  }

  ngOnInit(): void {
    let openingHours = {};
    openingHours['MONDAY'] = new OpeningHoursRange('MONDAY');
    openingHours['TUESDAY'] = new OpeningHoursRange('TUESDAY');
    openingHours['WEDNESDAY'] = new OpeningHoursRange('WEDNESDAY');
    openingHours['THURSDAY'] = new OpeningHoursRange('THURSDAY');
    openingHours['FRIDAY'] = new OpeningHoursRange('FRIDAY');
    openingHours['SATURDAY'] = new OpeningHoursRange('SATURDAY');
    openingHours['SUNDAY'] = new OpeningHoursRange('SUNDAY');

    this.companyService.getCompanies()
      .subscribe((companies: Array<Company>) => {
        this.companyList = companies;
      });

    this.iceCreamShop.openingHours.openingHours = openingHours;
  }

  save(): void {
    this.iceCreamShopService.save(this.iceCreamShop)
      .subscribe(() => {});
  }


}
