import { Pipe, PipeTransform } from '@angular/core';

import { Percentage } from '../../model/percentage.model';

@Pipe({
  name: 'lmbdPercentage',
})
export class PercentagePipe implements PipeTransform {

  private static DEFAULT_VALUE = '-';
  private static PERCENTAGE: string = '%';

  transform(percentage: Percentage, decimals: number = 2): string {
    if (!percentage) {
      return PercentagePipe.DEFAULT_VALUE + PercentagePipe.PERCENTAGE;
    }
    return PercentagePipe.formatValue(percentage.percentage, decimals);
  }

  private static formatValue(value: number, decimals: number) {
    return value.toFixed(decimals) + PercentagePipe.PERCENTAGE;
  }

}
