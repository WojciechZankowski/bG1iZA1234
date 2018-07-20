import { Component, Inject, OnInit } from '@angular/core';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { MAT_DIALOG_DATA, MatChipInputEvent } from '@angular/material';

import { CompanyService } from '../../services/company.service';
import { FlavorService } from '../../services/flavor.service';
import { ImageService } from '../../services/image.service';
import { Flavor } from '../../model/flavor.model';
import { Company } from '../../model/company.model';
import { FileUploadResponse } from '../../model/file-upload-response.model';

export interface Fruit {
  name: string;
}

@Component({
  templateUrl: './add-edit-flavor.component.html',
})
export class AddEditFlavorComponent implements OnInit {

  public readonly SELECTABLE = true;
  public readonly REMOVABLE = true;
  public readonly ADD_ON_BLUR = true;
  public readonly SEPARATOR_KEY_CODES: number[] = [ENTER, COMMA];
  public readonly DIAMETER = 30;

  public flavor: Flavor;
  public companyList: Company[] = [];
  public loading: boolean = false;
  public tags: string[] = [];

  private edit: boolean = false;

  constructor(private companyService: CompanyService,
              private flavorService: FlavorService,
              private imageService: ImageService,
              @Inject(MAT_DIALOG_DATA) public data: any) {

  }

  ngOnInit(): void {
    this.companyService.getCompanies()
      .subscribe((companies: Company[]) => {
        this.companyList = companies;
      });

    if (this.data != null) {
      this.flavor = this.data.flavor;
      this.tags = this.flavor.tags;
      this.edit = true;
    }

    if (!this.flavor) {
      this.flavor = new Flavor(null, '', '', [], new Company());
    }
  }

  save(): void {
    this.flavor.tags = this.tags;
    if (this.edit) {
      this.flavorService.update(this.flavor)
        .subscribe(() => {
        });
    } else {
      this.flavorService.save(this.flavor)
        .subscribe(() => {
        });
    }
  }

  handleFileInput(files: FileList) {
    const file = files.item(0);
    this.loading = true;
    this.imageService.save(file)
      .subscribe((file: FileUploadResponse) => {
        if (!!file) {
          this.flavor.imageUrl = file.name;
          this.loading = false;
        }
      });
  }

  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Add our tag
    if ((value || '').trim()) {
      this.tags.push(value.trim());
    }

    // Reset the input value
    if (input) {
      input.value = '';
    }
  }

  remove(fruit: string): void {
    const index = this.tags.indexOf(fruit);
    if (index >= 0) {
      this.tags.splice(index, 1);
    }
  }

  compareById(obj1: Company, obj2: Company): boolean {
    return obj1 && obj2 ? obj1.id === obj2.id : false;
  }

  getUrl() {
    const imageUrl = this.flavor.imageUrl;
    return imageUrl ? '...' + imageUrl.substring(imageUrl.length - 10, imageUrl.length) : '';
  }

}
