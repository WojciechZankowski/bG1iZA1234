import { Component, Input, OnInit } from "@angular/core";
import { Events } from "ionic-angular";
import { ProfilePage } from "../profile/profile.component";
import { FollowType } from "../../app/model/follow-type.model";
import { Follow } from "../../app/model/follow.model";
import { FollowService } from "../../app/services/follow.service";

@Component({
  selector: 'follow',
  templateUrl: './follow.component.html'
})
export class FollowComponent implements OnInit {

  @Input()
  public followedObjectId: number;

  @Input()
  public followType: FollowType;

  public follow: Follow;

  constructor(private followService: FollowService,
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
    this.followService.getMyFollow(FollowType[this.followType], this.followedObjectId)
      .subscribe((follow) => {
        this.follow = follow;
      });
  }

  getTopic(): string {
    return 'like:' + this.followType + ":" + this.followedObjectId;
  }

  onHeartClick(): void {
    if (this.follow) {
      this.followService.removeFollow(this.follow.id)
        .subscribe(() => {
          this.follow = undefined;
          this.events.publish(this.getTopic(), '')
        });
    } else {
      const follow = new Follow(null, FollowType[this.followType], this.followedObjectId);
      this.followService.addFollow(follow)
        .subscribe((follow) => {
          this.follow = follow;
          this.events.publish(this.getTopic(), '')
        });
    }
  }


}
