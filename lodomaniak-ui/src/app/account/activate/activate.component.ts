import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import { filter } from 'rxjs/operators';
import {AuthService} from "../../services/auth.service";
import {RegisterService} from "../../services/register.service";

@Component({
  templateUrl: './activate.component.html'
})
export class ActivateComponent implements OnInit{

  public title: string = 'ACCOUNT.FORM.ACTIVATE.TITLE';

  public loginPath = '/account/login';
  public routerActiveOptions = {exact: true};

  constructor(private registerService: RegisterService,
              private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.queryParams
      .pipe(filter(params => params.key))
      .subscribe(params => {
        console.log(params.key);
        this.registerService.activate(params.key).subscribe(() => {});
      })
  }


}
