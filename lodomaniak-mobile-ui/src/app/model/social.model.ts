export class Social {
  scope: string;
  _csrf: string;

  constructor(scope: string, csrf: string) {
    this.scope = scope;
    this._csrf = csrf;
  }
}
