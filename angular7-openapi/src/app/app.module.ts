import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ApiModule, BASE_PATH } from '@techshard/language-rest-api';
import { HttpClientModule } from '@angular/common/http';
import { environment } from './../environments/environment';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LanguageComponent } from './language/language.component';

@NgModule({
  declarations: [
    AppComponent,
    LanguageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ApiModule,
    HttpClientModule
  ],
  providers: [{ provide: BASE_PATH, useValue: environment.API_BASE_PATH }],
  bootstrap: [AppComponent]
})
export class AppModule { }
