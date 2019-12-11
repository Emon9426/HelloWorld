/* 程序的跟模块
  - 模块的职责：
      将程序的组件和服务，组织整合到一起
*/
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent] // → 启动了程序的根组件(启动组件)
})
export class AppModule { }
