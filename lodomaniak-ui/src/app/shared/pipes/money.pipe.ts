import { Pipe, PipeTransform } from '@angular/core';

import { Money } from '../../model/money.model';

@Pipe({
  name: 'lmbdMoney',
})
export class MoneyPipe implements PipeTransform {

  private static DEFAULT_VALUE = '-';

  transform(money: Money, decimals: number = 2): string {
    if (!money) {
      return MoneyPipe.DEFAULT_VALUE;
    }

    return MoneyPipe.formatValue(money.amount, money.currencyUnit.symbol, decimals);
  }

  private static formatValue(amount: number, symbol: string, decimals: number): string {
    return amount.toFixed(decimals) + symbol;
  }

}
