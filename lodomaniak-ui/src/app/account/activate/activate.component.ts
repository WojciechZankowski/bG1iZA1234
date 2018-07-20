import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { filter } from 'rxjs/operators';

import { RegisterService } from '../../services/register.service';
import { LOGIN_PATH, ROUTER_ACTIVE_OPTIONS } from '../../core/path.utilities';

@Component({
  templateUrl: './activate.component.html',
})
export class ActivateComponent implements OnInit {

  public readonly TITLE: string = 'ACCOUNT.FORM.ACTIVATE.TITLE';
  public readonly loginPath = LOGIN_PATH;
  public readonly routerActiveOptions = ROUTER_ACTIVE_OPTIONS;

  constructor(private registerService: RegisterService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.queryParams
      .pipe(filter(params => params.key))
      .subscribe((params) => {
        this.registerService.activate(params.key).subscribe(() => {
        });
      });
  }

}
