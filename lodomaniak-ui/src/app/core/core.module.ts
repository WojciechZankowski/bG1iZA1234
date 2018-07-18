import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { WebSocketService } from './web-socket.service';
import { ApiService } from './api.service';

@NgModule({
  imports: [
    HttpClientModule,
  ],
  declarations: [],
  providers: [
    WebSocketService,
    ApiService,
  ],
})
export class CoreModule {
}
