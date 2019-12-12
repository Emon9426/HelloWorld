//变量的声明
//  var     → 不推荐
//  let     → 变量
//  const   → 常量

let foo = 'bar';
foo = 'baz';

const count = 0;
//count = 10; // 常量被赋值后不能改

//基本数据类型
// 布尔值
    let isDone: boolean = true;
// 数字
    let num: number = 10;
// 字符串
    let foo_str: string = 'hello';
    //字符串也支持模板字符串
    var user: {
        name: string,
        age: number
    } = {
        name: 'Jack',
        age: 18
    }
    let str: string = '大家好，我叫: ${user.name}, 我今年${user.age}岁了';
// 数组
    let arr: Array<number> = [1,2,3]; // arr是一个数字类型的数组
    arr.push(11); // 增加数组元素

    let arr_a: number[] = [1,2,3]; // 数组的另一种声明方式
// 元组 - 不同数据类型的数组
    let arr_b: [number,string] = [10,'Jack'];
// Object 后面根对象
    let user_c: object = {
        name: 'Jack',
        age: 18
    };
// Interface
    interface persion{
        name: string,
        age: number
    };

    let user_d: persion = {
        name: 'Jack',
        age: 18
    }
// Any 可以是任何数据类型
    let num_a: any = 10;
    num_a = true;
    
    let ret: string = (num_a as string).substr(1); //指定Any类型的变量为指定类型的变量

// 变量用于形参
    function add(x: number,y: number): number{
        return x + y;
    }
    var ret_a: number = add(1,2);
// void - 只能用于函数的返回值
    function fn(): void {
        console.log('Hello');
    }

