export class Page<T> {
  content: T[];
  totalElements: number;
  totalPages: number;

  constructor(content?: T[], totalElements?: number, totalPages?: number) {
    this.content = content;
    this.totalElements = totalElements;
    this.totalPages = totalPages;
  }
}
