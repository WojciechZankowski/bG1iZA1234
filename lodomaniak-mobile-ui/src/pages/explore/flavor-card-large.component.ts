import { Component, Input } from "@angular/core";
import { Flavor } from "../../app/model/flavor.model";
import { NavController } from "ionic-angular";
import { FlavorComponent } from "./flavor.component";

@Component({
  selector: 'flavor-card-large',
  templateUrl: './flavor-card-large.component.html',
})
export class FlavorCardLargeComponent {

  @Input()
  public flavor: Flavor;

  constructor(public navCtrl: NavController) {
  }

  getImg(): string {
    return this.flavor ? 'assets/imgs/content/' + this.flavor.imageUrl : '';
  }

  public onClick(): void {
    this.navCtrl.push(FlavorComponent, {
      flavor: this.flavor
    });
  }

}
