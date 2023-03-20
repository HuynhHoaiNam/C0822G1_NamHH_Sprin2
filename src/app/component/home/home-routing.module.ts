import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListWatchComponent} from './list-watch/list-watch.component';
import {CardComponent} from './card/card.component';
import {DetailComponent} from './detail/detail.component';

const routes: Routes = [
  {path: '', component: ListWatchComponent},
  {path: 'card', component: CardComponent},
  {path: 'detail', component: DetailComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}
