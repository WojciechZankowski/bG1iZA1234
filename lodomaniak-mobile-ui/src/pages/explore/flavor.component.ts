import { Component, OnInit } from "@angular/core";
import { NavParams } from "ionic-angular";
import { Flavor } from "../../app/model/flavor.model";
import { FlavorSchedule } from "../../app/model/flavor-schedule.model";
import { FlavorService } from "../../app/services/flavor.service";
import { RatingType } from "../../app/model/rating-type.model";
import { FollowType } from "../../app/model/follow-type.model";

@Component({
  selector: 'flavor',
  templateUrl: './flavor.component.html'
})
export class FlavorComponent implements OnInit {

  public readonly RATING_TYPE = RatingType.FLAVOR;
  public readonly FOLLOW_TYPE = FollowType.FLAVOR;

  public flavor: Flavor;
  public flavorSchedules: FlavorSchedule[] = [];

  constructor(private navParams: NavParams,
              private flavorService: FlavorService) {

  }

  ngOnInit(): void {
    this.flavor = this.navParams.get('flavor');
    this.flavorService.getTodaysSchedules(this.flavor.id)
      .subscribe((flavorSchedules) => {
        this.flavorSchedules = flavorSchedules;
      });
  }

  getImg(): string {
    return this.flavor ? 'assets/imgs/content/' + this.flavor.imageUrl : '';
  }

}
