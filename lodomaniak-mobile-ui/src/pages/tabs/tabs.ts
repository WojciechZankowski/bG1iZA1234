import { Component } from '@angular/core';
import { ExplorePage } from '../explore/explore.component';
import { RankingPage } from "../ranking/ranking.component";
import { ProfilePage } from "../profile/profile.component";

@Component({
  templateUrl: 'tabs.html'
})
export class TabsPage {

  tab1Root = ExplorePage;
  tab2Root = RankingPage;
  tab3Root = ProfilePage;

  constructor() {

  }
}
