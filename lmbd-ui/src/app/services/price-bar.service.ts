import {Injectable} from "@angular/core";
import {Subject} from "rxjs/Subject";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/map';

import {WebSocketService} from "../core/web-socket.service";
import {TickData} from "../model/tick-data.model";
import {ApiService} from "../core/api.service";
import {HttpParams} from "@angular/common/http";

export const TICK_DATA_PATH = '/ws-commodities';
export const COMMODITIES_PATH = '/commodities';
export const SYMBOLS_PATH = COMMODITIES_PATH + '/symbols';

@Injectable()
export class PriceBarService {

  public messages: Subject<TickData>;

  constructor(private webSocketService: WebSocketService,
              private apiService: ApiService) {
    this.messages = <Subject<TickData>>webSocketService
      .connect(TICK_DATA_PATH)
      .map((response: MessageEvent) => {
        const data = JSON.parse(response.data);
        return data;
      });
  }

  getSymbols(): Observable<String[]> {
    let test = this.apiService.get(SYMBOLS_PATH);
    console.log(test);

    return test;
  }

  getTickData(symbols: string[]): Observable<Array<TickData>> {
    return this.apiService.get(COMMODITIES_PATH,
      new HttpParams({fromObject: {'symbols': symbols}}));
  }

}
