import {Component, Inject, Input, OnInit} from "@angular/core";
import {MatDialog} from "@angular/material";
import {IceCreamShop} from "../../model/ice-cream-shop.model";
import {Address} from "../../model/address.model";
import {OpeningHours} from "../../model/opening-hours.model";
import {Company} from "../../model/company.model";
import {OpeningHoursRange} from "../../model/opening-hours-range.model";
import {CompanyService} from "../../services/company.service";
import {IceCreamShopService} from "../../services/ice-cream-shop.service";
import {MAT_DIALOG_DATA} from '@angular/material';

@Component({
  templateUrl: './add-edit-shops.component.html',
  styleUrls: ['./add-edit-shops.component.scss']
})
export class AddEditShopsComponent implements OnInit {

  @Input()
  public iceCreamShop: IceCreamShop;

  public companyList: Array<Company> = [];
  public objectKeys = Object.keys;

  constructor(private companyService: CompanyService,
              private iceCreamShopService: IceCreamShopService,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit(): void {
    this.companyService.getCompanies()
      .subscribe((companies: Array<Company>) => {
        this.companyList = companies;
      });

    this.iceCreamShop = this.data.iceCreamShop;

    if (!this.iceCreamShop) {
      this.iceCreamShop = new IceCreamShop(new Company(), new Address(), new OpeningHours());

      let openingHours = {};
      openingHours['MONDAY'] = new OpeningHoursRange('MONDAY');
      openingHours['TUESDAY'] = new OpeningHoursRange('TUESDAY');
      openingHours['WEDNESDAY'] = new OpeningHoursRange('WEDNESDAY');
      openingHours['THURSDAY'] = new OpeningHoursRange('THURSDAY');
      openingHours['FRIDAY'] = new OpeningHoursRange('FRIDAY');
      openingHours['SATURDAY'] = new OpeningHoursRange('SATURDAY');
      openingHours['SUNDAY'] = new OpeningHoursRange('SUNDAY');

      this.iceCreamShop.openingHours.openingHours = openingHours;
    }
  }

  save(): void {
    this.iceCreamShopService.save(this.iceCreamShop)
      .subscribe(() => {
      });
  }

}
