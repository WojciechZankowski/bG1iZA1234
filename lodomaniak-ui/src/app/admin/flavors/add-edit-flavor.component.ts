import {Component, Inject, OnInit} from "@angular/core";
import {CompanyService} from "../../services/company.service";
import {FlavorService} from "../../services/flavor.service";
import {ImageService} from "../../services/image.service";
import {MAT_DIALOG_DATA} from "@angular/material";
import {Flavor} from "../../model/flavor.model";
import {Company} from "../../model/company.model";
import {FileUploadResponse} from "../../model/file-upload-response.model";

@Component({
  templateUrl: './add-edit-flavor.component.html',
  styleUrls: ['./add-edit-flavor.component.scss']
})
export class AddEditFlavorComponent implements OnInit {

  public flavor: Flavor;
  public companyList: Array<Company> = [];

  private edit: boolean = false;

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
      this.flavor = new Flavor(null, "", "", new Company());
    }
  }

  save(): void {
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


}
