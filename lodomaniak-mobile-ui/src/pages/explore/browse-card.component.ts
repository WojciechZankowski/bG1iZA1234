import { Component, Input } from "@angular/core";

@Component({
  selector: 'browse-card',
  templateUrl: './browse-card.component.html'
})
export class BrowseCardComponent {

  @Input()
  public imageUrl: string;

  @Input()
  public title: string;

}
