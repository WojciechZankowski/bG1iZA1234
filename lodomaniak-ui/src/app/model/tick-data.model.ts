import { Money } from './money.model';
import { Percentage } from './percentage.model';

export class TickData {
  ticker: string;
  price: Money;
  change: number;
  changeInPercentage: Percentage;
  time: Date;
}
