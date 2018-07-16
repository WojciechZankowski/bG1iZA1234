import {Component, Inject, OnInit} from "@angular/core";
import {CompanyService} from "../../services/company.service";
import {FlavorService} from "../../services/flavor.service";
import {ImageService} from "../../services/image.service";
import {MAT_DIALOG_DATA, MatChipInputEvent} from "@angular/material";
import {Flavor} from "../../model/flavor.model";
import {Company} from "../../model/company.model";
import {FileUploadResponse} from "../../model/file-upload-response.model";
import {COMMA, ENTER} from "@angular/cdk/keycodes";

export interface Fruit {
  name: string;
}

@Component({
  templateUrl: './add-edit-flavor.component.html',
  styleUrls: ['./add-edit-flavor.component.scss']
})
export class AddEditFlavorComponent implements OnInit {

  public flavor: Flavor;
  public companyList: Array<Company> = [];

  private edit: boolean = false;

  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true;
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  tags: string[] = [];

  constructor(private companyService: CompanyService,
              private flavorService: FlavorService,
              private imageService: ImageService,
              @Inject(MAT_DIALOG_DATA) public data: any) {

  }

  ngOnInit(): void {
    this.companyService.getCompanies()
      .subscribe((companies: Array<Company>) => {
        this.companyList = companies;
      });

    if (this.data != null) {
      this.flavor = this.data.flavor;
      this.edit = true;
    }

    if (!this.flavor) {
      this.flavor = new Flavor(null, "", "", [], new Company());
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
    this.imageService.save(file)
      .subscribe((file: FileUploadResponse) => {
        if (!!file) {
          this.flavor.imageUrl = file.name;
        }
      })
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

}
