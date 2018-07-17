import * as moment from 'moment';

declare interface Date {
  toJSON: (key?: any) => string;
}

(function () {
  Date.prototype.toJSON = function (key?: any) {
    return moment(this).format("YYYY-MM-DD");
  }
})();
