import {Component, OnInit} from "@angular/core";
import {PriceBarService} from "../../services/price-bar.service";
import {TickData} from "../../model/tick-data.model";

@Component({
  selector: 'lodomaniak-price-bar',
  templateUrl: './price-bar.component.html',
  styleUrls: ['./price-bar.component.scss']
})
export class PriceBarComponent implements OnInit {

  public priceBarItems: Array<TickData> = [];

  constructor(private priceBarService: PriceBarService) {
  }

  ngOnInit(): void {
    this.priceBarService.messages.subscribe(data => {
      if (!data) {
        return;
      }

      const itemIndex = this.priceBarItems.findIndex(item => item.ticker === data.ticker);
      if (itemIndex >= 0) {
        this.priceBarItems[itemIndex] = data;
      } else {
        this.priceBarItems.push(data);
      }
      this.priceBarItems = [...this.priceBarItems];
    });

    this.priceBarService.getSymbols().subscribe((symbols: string[]) => {
      this.priceBarService.getTickData(symbols).subscribe((tickData) => {
        this.priceBarItems = tickData;
      });
    });
  }

}
