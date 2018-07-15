export class PageRequest {
  page: number;
  size: number;
  direction: string;
  properties: string;

  constructor(page: number, size: number, direction: string, properties: string) {
    this.page = page;
    this.size = size;
    this.direction = direction;
    this.properties = properties;
  }
}
