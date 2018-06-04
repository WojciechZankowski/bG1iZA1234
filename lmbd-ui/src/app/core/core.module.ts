import {NgModule} from "@angular/core";
import {WebSocketService} from "./web-socket.service";
import {HttpClientModule} from "@angular/common/http";
import {ApiService} from "./api.service";

@NgModule({
  imports: [
    HttpClientModule
  ],
  declarations: [],
  providers: [
    WebSocketService,
    ApiService
  ]
})
export class CoreModule {
}
