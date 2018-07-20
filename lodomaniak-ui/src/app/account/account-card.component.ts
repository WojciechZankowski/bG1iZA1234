import { Component, Input } from '@angular/core';

@Component({
  selector: 'lodomaniak-account-card',
  templateUrl: './account-card.component.html',
})
export class AccountCardComponent {

  @Input() title: string;

}
