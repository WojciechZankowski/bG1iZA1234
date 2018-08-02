import { Component, Input, OnInit } from "@angular/core";
import { RatingType } from "../../app/model/rating-type.model";
import { Rating } from "../../app/model/rating.model";
import { RatingService } from "../../app/services/rating.service";
import { Events } from "ionic-angular";
import { ProfilePage } from "../profile/profile.component";

@Component({
  selector: 'like',
  templateUrl: './like.component.html'
})
export class LikeComponent implements OnInit {

  @Input()
  public ratedObjectId: number;

  @Input()
  public ratingType: RatingType;

  public rating: Rating;

  constructor(private ratingService: RatingService,
              public events: Events) {
  }

  ngOnInit(): void {
    this.fetchData();
    this.events.subscribe(this.getTopic(), (value) => {
      this.fetchData();
    });
    this.events.subscribe(ProfilePage.LOGIN_KEY, (value) => {
      this.fetchData();
    });
  }

  fetchData(): void {
    this.ratingService.getMyRating(RatingType[this.ratingType], this.ratedObjectId)
      .subscribe((rating) => {
        this.rating = rating;
      });
  }

  getTopic(): string {
    return 'like:' + this.ratingType + ":" + this.ratedObjectId;
  }

  onHeartClick(): void {
    if (this.rating) {
      this.ratingService.removeRating(this.rating.id)
        .subscribe(() => {
          this.rating = undefined;
          this.events.publish(this.getTopic(), '')
        });
    } else {
      const rating = new Rating(null, RatingType[this.ratingType], this.ratedObjectId);
      this.ratingService.addRating(rating)
        .subscribe((rating) => {
          this.rating = rating;
          this.events.publish(this.getTopic(), '')
        });
    }
  }

}
