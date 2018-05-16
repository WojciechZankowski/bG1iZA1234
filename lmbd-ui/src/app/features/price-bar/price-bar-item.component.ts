import {Component, Input} from "@angular/core";

import {TickData} from "../../model/tick-data.model";
import {Money} from "../../model/money.model";

@Component({
  selector: 'lmbd-price-bar-item',
  templateUrl: './price-bar-item.component.html',
  styleUrls: ['./price-bar-item.component.scss']
})
export class PriceBarItemComponent {

  private static OUNCE_TO_GRAM: number = 28.3495231;

  @Input() public tickData: TickData;

  public convertPriceToGrams(value: Money): Money {
    return {
      amount: this.convertPriceToGramsLogic(value.amount),
      currencyUnit: value.currencyUnit
    };
  }

  private convertPriceToGramsLogic(value: number): number {
    return value ? value / PriceBarItemComponent.OUNCE_TO_GRAM : value;
  }

  public getColor(value: number): string {
    if (!value) {
      return '';
    }
    if (value < 0) {
      return 'price-bar-item-red';
    } else if (value > 0) {
      return 'price-bar-item-green';
    } else {
      return ''
    }
  }

}
