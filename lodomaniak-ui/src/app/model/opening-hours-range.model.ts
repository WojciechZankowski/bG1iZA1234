export class OpeningHoursRange {
  dayOfWeek: string;
  openHour: string;
  closeHour: string;


  constructor(dayOfWeek?: string, openHour?: string, closeHour?: string) {
    this.dayOfWeek = dayOfWeek;
    this.openHour = openHour;
    this.closeHour = closeHour;
  }
}
