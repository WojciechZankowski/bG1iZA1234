export class Page<T> {
  content: Array<T>;
  totalElements: number;

  constructor(content?: Array<T>, totalElements?: number) {
    this.content = content;
    this.totalElements = totalElements;
  }
}
