import {Component, OnInit} from '@angular/core';
import {TranslateService} from "@ngx-translate/core";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';

  constructor(private translateService: TranslateService) {
  }

  ngOnInit(): void {
    this.translateService.setDefaultLang('pl');
    this.translateService.use('pl');
  }

}
