//程序的根组件
/* Memo
  - 组件就是一个类
  - 用于管理视图

*/
import { Component } from '@angular/core';

@Component({                             // → 组件的装饰器，用于修饰组件的特性
  selector: 'app-root',                  // → 用于定义组件渲染的标签名称，需要和Index.html中的程序出口标签保持一致
  templateUrl: './app.component.html',   // → 用于指定组件的模板文件
  styleUrls: ['./app.component.css']     // → 一个数组，用于存放组件相关的样式文件
})
export class AppComponent {
  // 组件相关的内容数据
  title = 'my-app';
  count = 0;
  // 组件中的方法
  increment = function () {
    this.count++; // 使用this关键字访问组件内的资源
  }
}
