import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // 此处为页面的数据来源
  title = 'my-app';
  // 数据绑定实验
  count = 100;
  // 方法实验
  count_fnc = 0;
  increment = function () {
    //在组件方法中，可以直接通过this访问组件成员
    this.count_fnc++;
  }
}

