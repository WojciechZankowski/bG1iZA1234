import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material';

import { IceCreamShop } from '../../model/ice-cream-shop.model';
import { Address } from '../../model/address.model';
import { Company } from '../../model/company.model';
import { OpeningHoursRange } from '../../model/opening-hours-range.model';
import { CompanyService } from '../../services/company.service';
import { IceCreamShopService } from '../../services/ice-cream-shop.service';
import { ImageService } from '../../services/image.service';
import { FileUploadResponse } from '../../model/file-upload-response.model';
import { DayOfWeek } from '../../model/day-of-week.model';

@Component({
  templateUrl: './add-edit-shops.component.html',
  styleUrls: ['./add-edit-shops.component.scss'],
})
export class AddEditShopsComponent implements OnInit {

  public iceCreamShop: IceCreamShop;
  public companyList: Company[] = [];

  public readonly diameter = 30;
  public readonly DAY_OF_WEEK = Object.keys(DayOfWeek)
    .map(key => DayOfWeek[key])
    .filter(value => typeof value === 'string') as string[];

  public loading: boolean = false;
  private edit: boolean = false;

  constructor(private companyService: CompanyService,
              private iceCreamShopService: IceCreamShopService,
              private imageService: ImageService,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit(): void {
    this.companyService.getCompanies()
      .subscribe((companies: Company[]) => {
        this.companyList = companies;
      });

    if (this.data != null) {
      this.iceCreamShop = this.data.iceCreamShop;
      this.edit = true;
    }

    if (!this.iceCreamShop) {
      this.iceCreamShop = new IceCreamShop(null, '', new Company(), new Address(), {});

      const openingHours = {};
      openingHours['MONDAY'] = new OpeningHoursRange(null, 'MONDAY');
      openingHours['TUESDAY'] = new OpeningHoursRange(null, 'TUESDAY');
      openingHours['WEDNESDAY'] = new OpeningHoursRange(null, 'WEDNESDAY');
      openingHours['THURSDAY'] = new OpeningHoursRange(null, 'THURSDAY');
      openingHours['FRIDAY'] = new OpeningHoursRange(null, 'FRIDAY');
      openingHours['SATURDAY'] = new OpeningHoursRange(null, 'SATURDAY');
      openingHours['SUNDAY'] = new OpeningHoursRange(null, 'SUNDAY');

      this.iceCreamShop.openingHours = openingHours;
    }
  }

  save(): void {
    if (this.edit) {
      this.iceCreamShopService.update(this.iceCreamShop)
        .subscribe(() => {
        });
    } else {
      this.iceCreamShopService.save(this.iceCreamShop)
        .subscribe(() => {
        });
    }
  }

  getUrl() {
    const imageUrl = this.iceCreamShop.imageUrl;
    return imageUrl ? '...' + imageUrl.substring(imageUrl.length - 10, imageUrl.length) : '';
  }

  compareById(obj1: Company, obj2: Company): boolean {
    return obj1 && obj2 ? obj1.id === obj2.id : false;
  }

  handleFileInput(files: FileList) {
    const file = files.item(0);
    this.loading = true;
    this.imageService.save(file)
      .subscribe((file: FileUploadResponse) => {
        if (!!file) {
          this.iceCreamShop.imageUrl = file.name;
          this.loading = false;
        }
      });
  }

}
