import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListWatchComponent } from './component/home/list-watch/list-watch.component';
import { CardComponent } from './component/home/card/card.component';
import { HeaderComponent } from './component/home/header/header.component';
import { FooterComponent } from './component/home/footer/footer.component';
import { DetailComponent } from './component/home/detail/detail.component';
import { LoginComponent } from './component/login/login.component';
import {HomeModule} from './component/home/home.module';

@NgModule({
  declarations: [
    AppComponent,
    ListWatchComponent,
    CardComponent,
    HeaderComponent,
    FooterComponent,
    DetailComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
