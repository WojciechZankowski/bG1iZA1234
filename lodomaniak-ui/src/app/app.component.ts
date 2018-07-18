import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import './core/extension/date.extension';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {

  constructor(private translateService: TranslateService) {
  }

  ngOnInit(): void {
    this.translateService.setDefaultLang('pl');
    this.translateService.use('pl');
  }

}
