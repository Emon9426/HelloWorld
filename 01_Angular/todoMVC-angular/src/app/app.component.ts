// 20191218-Feature1：数据列表的展示
import { Component } from '@angular/core';
// 20191218-Feature1 数组定义- start
const todos = [
//  {
//    id: 1,
//    title: '吃饭1',
//    done: true
//  },
//  {
//    id: 2,
//    title: '吃饭2',
//    done: true
//  },
//  {
//    id: 3,
//    title: '吃饭3',
//    done: true
//  }
]; 
// 20191218-Feature1 数组定义- end

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // 20191218-Feature1 - start
  public todos: {
    id: number,
    title: string,
    done: boolean
  }[] = todos;

  // 20191218-Feature1 - end

  // 事件添加
  addTodo(e): void{
    console.log(e.keyCode);      //TEST
    console.log(e.target.value); //TEST
    const titleText = e.target.value;
    if (!titleText.length){
      return 
    }
    const last = this.todos[this.todos.length - 1]; //获取数组todos的最后一个元素

    this.todos.push(
      {
        id: last ? last.id + 1: 1, //数组todos有没有最后一个元素? 如果有则读取它的id并+1: 如果没有则就为1 (类似于decode)
        title: titleText,
        done: false
      }
    );
    e.target.value = '';
  }
}
