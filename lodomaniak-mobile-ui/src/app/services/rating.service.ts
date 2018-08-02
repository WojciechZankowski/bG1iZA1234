import { Injectable } from "@angular/core";
import { ApiService } from "../core/api.service";
import { Rating } from "../model/rating.model";
import { Observable } from "rxjs/Observable";
import { HttpParams } from "@angular/common/http";
import { map } from "rxjs/operators";

export const RATING_PATH = '/rating';
export const MY_RATING_PATH = '/rating/mine';

@Injectable()
export class RatingService {

  constructor(private apiService: ApiService) {
  }

  getMyRating(ratingType: string, ratedObjectId: number) {
    return this.apiService.get(MY_RATING_PATH, new HttpParams({
      fromObject: {
        ratingType: ratingType,
        ratedObjectId: ratedObjectId.toString(),
      }
    }));
  }

  addRating(rating: Rating): Observable<Rating> {
    return this.apiService.post(RATING_PATH, rating)
      .pipe(map((response) => (response.body)));
  }

  removeRating(ratingId: number): Observable<any> {
    return this.apiService.delete(RATING_PATH + '/' + ratingId.toString());
  }

}
