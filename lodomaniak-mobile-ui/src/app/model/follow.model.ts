import { FollowType } from "./follow-type.model";

export class Follow {

  id: number;
  followType: FollowType;
  followedObjectId: number;

  constructor(id?: number, followType?: FollowType, followedObjectId?: number) {
    this.id = id;
    this.followType = followType;
    this.followedObjectId = followedObjectId;
  }

}
