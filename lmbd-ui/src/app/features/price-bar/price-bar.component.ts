import {Component, OnInit} from "@angular/core";
import {PriceBarService} from "../../services/price-bar.service";
import {TickData} from "../../model/tick-data.model";

@Component({
  selector: 'lmbd-price-bar',
  templateUrl: './price-bar.component.html',
  styleUrls: ['./price-bar.component.scss']
})
export class PriceBarComponent implements OnInit {

  public xauTickData: TickData;
  public xagTickData: TickData;

  constructor(private priceBarService: PriceBarService) {
  }

  ngOnInit(): void {
    this.priceBarService.messages.subscribe(data => {
      if (this.isGold(data)) {
        this.xauTickData = data;
      } else if (this.isSilver(data)) {
        this.xagTickData = data;
      }
    })
  }

  private isGold(tickData: TickData): boolean {
    return tickData.ticker.startsWith("XAU");
  }

  private isSilver(tickData: TickData): boolean {
    return tickData.ticker.startsWith("XAG");
  }

}
