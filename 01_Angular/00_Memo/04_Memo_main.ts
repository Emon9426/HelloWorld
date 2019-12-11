// 整个模块化系统启动的入口
// 1. 加载跟模块
// 2. 启动执行模块系统
import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule) // → 程序加载的跟模块 - AppModule
  .catch(err => console.error(err));
