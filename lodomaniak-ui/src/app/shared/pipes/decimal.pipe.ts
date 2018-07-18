import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'lmbdDecimal',
})
export class DecimalPipe implements PipeTransform {

  private static DEFAULT_VALUE = '-';

  transform(value: number, decimals: number = 2): string {
    if (!value) {
      return DecimalPipe.DEFAULT_VALUE;
    }

    return DecimalPipe.formatValue(value, decimals);
  }

  private static formatValue(amount: number, decimals: number): string {
    return amount.toFixed(decimals);
  }

}
