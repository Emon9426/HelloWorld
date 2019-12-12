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
    //进行模块的声明资源，包括组件、指令、路由
    AppComponent
  ],
  imports: [
    //模块的导入，依赖的其他模块
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent] // → 启动了程序的根组件(启动组件)
})
export class AppModule { } //将这个模块导出，外部才可以使用
