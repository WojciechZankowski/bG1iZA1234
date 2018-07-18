import { Component, Input } from '@angular/core';

@Component({
  selector: 'lodomaniak-account-card',
  templateUrl: './account-card.component.html',
  styleUrls: ['./account-card.component.scss'],
})
export class AccountCardComponent {

  @Input() title: string;

}
