import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { MyApp } from './app.component';

import { ExplorePage } from '../pages/explore/explore.component';
import { TabsPage } from '../pages/tabs/tabs';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { ProfilePage } from "../pages/profile/profile.component";
import { RankingPage } from "../pages/ranking/ranking.component";
import { FeaturesModule } from "./features/features.module";
import { CookieModule } from "ngx-cookie";
import { ServiceModule } from "./services/service.module";

@NgModule({
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    FeaturesModule,
    CookieModule.forRoot(),
    ServiceModule,
  ],
  declarations: [
    MyApp,
    ExplorePage,
    ProfilePage,
    RankingPage,
    TabsPage
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    ExplorePage,
    ProfilePage,
    RankingPage,
    TabsPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler }
  ],
})
export class AppModule {
}
