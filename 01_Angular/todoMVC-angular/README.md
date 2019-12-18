
# TodoMVCAngular

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.3.20.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).


## 学习笔记

### 引入模板
- 引入模板，将要引入的模板中 html文件的 body部分(body - footer) 替代掉组件中component.html中的代码即可。
- 其中component.html中的引入的代码，便可以替代index.html中的模板标签

### 引入全局样式
- 引入全局样式，在angular.json中 styles属性中指定的css文件中，import即可
- import前需要先安装要引入的css
#### 安装要引入的css文件
- 以 ```<link rel="stylesheet" href="node_modules/todomvc-common/base.css">``` 为例
- 其中 ```todomvc-common``` 为该css文件所用的资源名称
- 在工程目录下执行
    ``` npm install todomvc-common ```
  多个包的情况可以使用
    ``` npm install package1 package2 ```
- 安装成功后，在styles.css文件中 import 这个包
    ``` @import url('todomvc-common/base.css'); ```

### 在页面中循环展示数据列表
- 语法
    HTML ```*ngFor="let 变量名(任意名) of 数组名(在component中定义)"``` 循环数据列表
    HTML ```<label>{{ todo.title }}</label>``` 调用数组元素
    * 详细参照 app.component.html *

### 条件渲染
- 语法
    HTML ```*ngIf="todos.length"```
    结合ng-template
    HTML ```<ng-template [ngIf]="todos.length"> ... </ng-template>```
    * 详细参照 app.component.html *

### 事件添加
- 语法
    HTML ```(事件)="component中定义的方法"```
#### 键盘事件
- 获取键盘上的按键
    HTML ```<input class="new-todo" placeholder="What needs to be done?" autofocus (keyup)="addTodo($event)">```
    TS   ```  addTodo(e): void{         ```
         ```  console.log(e.keyCode);}  ```
    或使用angular定义的事件
    HTML ```<input class="new-todo" placeholder="What needs to be done?" autofocus (keyup.enter)="addTodo($event)">```
- 在component.ts中通过事件参数获取HTML页中控件的值
  * 详细参照 app.component.ts addTodo(e)

### 分支判断
- 语法
    TS ``` 变量(是否存在) ? 如果存在 : 如果不存在 ```