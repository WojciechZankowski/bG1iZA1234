import { Injectable } from "@angular/core";
import { ApiService } from "../core/api.service";
import { Observable } from "rxjs/Observable";
import { map } from "rxjs/operators";
import { Follow } from "../model/follow.model";
import { HttpParams } from "@angular/common/http";

export const MY_FOLLOW_PATH = '/follow/mine';
export const FOLLOW_PATH = '/follow';

@Injectable()
export class FollowService {

  constructor(private apiService: ApiService) {
  }

  getMyFollow(followType: string, followedObjectId: number) {
    return this.apiService.get(MY_FOLLOW_PATH, new HttpParams({
      fromObject: {
        followType: followType,
        followedObjectId: followedObjectId.toString(),
      }
    }));
  }

  addFollow(follow: Follow): Observable<Follow> {
    return this.apiService.post(FOLLOW_PATH, follow)
      .pipe(map((response) => (response.body)));
  }

  removeFollow(followId: number): Observable<any> {
    return this.apiService.delete(FOLLOW_PATH + '/' + followId.toString());
  }

}
