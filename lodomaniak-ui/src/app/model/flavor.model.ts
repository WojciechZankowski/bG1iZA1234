import {Company} from "./company.model";

export class Flavor {
  id: number;
  name: string;
  imageUrl: string;
  tags: string[];
  company: Company;


  constructor(id?: number, name?: string, imageUrl?: string, tags?: string[], company?: Company) {
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.tags = tags;
    this.company = company;
  }
}
