export class Page<T> {
  content: T[];
  totalElements: number;

  constructor(content?: T[], totalElements?: number) {
    this.content = content;
    this.totalElements = totalElements;
  }
}
