export class Rating {

  id: number;
  ratingType: string;
  ratedObjectId: number;

  constructor(id?: number, ratingType?: string, ratedObjectId?: number) {
    this.id = id;
    this.ratingType = ratingType;
    this.ratedObjectId = ratedObjectId;
  }

}
