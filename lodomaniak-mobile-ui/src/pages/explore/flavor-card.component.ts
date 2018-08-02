import { Component, Input } from "@angular/core";
import { FlavorComponent } from "./flavor.component";
import { RatingType } from "../../app/model/rating-type.model";
import { NavController } from "ionic-angular";
import { Flavor } from "../../app/model/flavor.model";

@Component({
  selector: 'flavor-card',
  templateUrl: './flavor-card.component.html'
})
export class FlavorCardComponent {

  @Input()
  public flavor: Flavor;

  public readonly RATING_TYPE = RatingType.FLAVOR;

  constructor(public navCtrl: NavController) {
  }

  getImg(): string {
    return this.flavor ? 'assets/imgs/content/' + this.flavor.imageUrl : '';
  }

  onClick(): void {
    this.navCtrl.push(FlavorComponent, {
      flavor: this.flavor
    });
  }

}
