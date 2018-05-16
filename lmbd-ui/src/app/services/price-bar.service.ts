import {Injectable} from "@angular/core";
import {Subject} from "rxjs/Subject";
import 'rxjs/add/operator/map';

import {WebSocketService} from "../core/web-socket.service";
import {TickData} from "../model/tick-data.model";

export const TICK_DATA_PATH = "/ws-commodities";

@Injectable()
export class PriceBarService {

  public messages: Subject<TickData>;

  constructor(private webSocketService: WebSocketService) {
    this.messages = <Subject<TickData>>webSocketService
      .connect(TICK_DATA_PATH)
      .map((response: MessageEvent) => {
        const data = JSON.parse(response.data);
        return data;
      });
  }


}
