export class Follow {

  id: number;
  followType: string;
  followedObjectId: number;

  constructor(id?: number, followType?: string, followedObjectId?: number) {
    this.id = id;
    this.followType = followType;
    this.followedObjectId = followedObjectId;
  }

}
