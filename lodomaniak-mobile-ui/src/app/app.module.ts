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
import { CookieModule } from "ngx-cookie";
import { ServiceModule } from "./services/service.module";
import { Facebook } from "@ionic-native/facebook";
import { IonicStorageModule, Storage } from '@ionic/storage';
import { JWT_OPTIONS, JwtModule } from "@auth0/angular-jwt";
import { SelectSearchableModule } from "ionic-select-searchable";
import { BrowseCardComponent } from "../pages/explore/browse-card.component";
import { NavbarComponent } from "../pages/explore/navbar.component";
import { SharedModule } from "./shared/shared.module";
import { IceCreamShopCardComponent } from "../pages/explore/ice-cream-shop-card.component";
import { IceCreamShopCardLargeComponent } from "../pages/explore/ice-cream-shop-card-large.component";
import { FlavorCardComponent } from "../pages/explore/flavor-card.component";
import { FlavorComponent } from "../pages/explore/flavor.component";
import { IceCreamShopComponent } from "../pages/explore/ice-cream-shop.component";

export function jwtOptionsFactory(storage) {
  return {
    tokenGetter: () => {
      return storage.get('access_token');
    }
  }
}

@NgModule({
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp, {
      backButtonText: 'Wróć'
    }),
    IonicStorageModule.forRoot(),
    CookieModule.forRoot(),
    ServiceModule,
    SharedModule,
    SelectSearchableModule,
    JwtModule.forRoot({
      jwtOptionsProvider: {
        provide: JWT_OPTIONS,
        useFactory: jwtOptionsFactory,
        deps: [Storage]
      }
    })
  ],
  declarations: [
    MyApp,
    ExplorePage,
    ProfilePage,
    RankingPage,
    TabsPage,
    IceCreamShopCardComponent,
    FlavorCardComponent,
    BrowseCardComponent,
    NavbarComponent,
    FlavorComponent,
    IceCreamShopCardLargeComponent,
    IceCreamShopComponent
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    ExplorePage,
    ProfilePage,
    RankingPage,
    TabsPage,
    IceCreamShopCardComponent,
    FlavorCardComponent,
    BrowseCardComponent,
    NavbarComponent,
    FlavorComponent,
    IceCreamShopCardLargeComponent,
    IceCreamShopComponent
  ],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    Facebook
  ],
})
export class AppModule {
}
