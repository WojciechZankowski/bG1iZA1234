export class OpeningHoursRange {
  id: number;
  dayOfWeek: string;
  openHour: string;
  closeHour: string;

  constructor(id?: number, dayOfWeek?: string, openHour?: string, closeHour?: string) {
    this.id = id;
    this.dayOfWeek = dayOfWeek;
    this.openHour = openHour;
    this.closeHour = closeHour;
  }
}
