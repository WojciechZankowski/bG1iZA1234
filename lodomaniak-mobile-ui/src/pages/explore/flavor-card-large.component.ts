import { Component, Input } from "@angular/core";
import { Flavor } from "../../app/model/flavor.model";

@Component({
  selector: 'flavor-card-large',
  templateUrl: './flavor-card-large.component.html',
})
export class FlavorCardLargeComponent {

  @Input()
  public flavor: Flavor;

  getImg(): string {
    return this.flavor ? 'assets/imgs/content/' + this.flavor.imageUrl : '';
  }

}
