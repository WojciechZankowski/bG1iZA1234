import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import { filter } from 'rxjs/operators';

@Component({
  templateUrl: './activate.component.html'
})
export class ActivateComponent implements OnInit{

  public title: string = 'ACCOUNT.FORM.ACTIVATE.TITLE';

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.queryParams
      .pipe(filter(params => params.key))
      .subscribe(params => {
        console.log(params)
      })
  }


}
