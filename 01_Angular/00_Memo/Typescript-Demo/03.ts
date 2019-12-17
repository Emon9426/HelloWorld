//结构赋值

// 1.数组的解构
let arr_03: number[] = [10,20];

let num1: number = arr_03[0];
let num2: number = arr_03[1];
let [num3,num4] = arr_03; //会自动匹配arr_03的各个元素(从0开始)

// 2.对象的解构
let user_03 = {
    name: 'Jack',
    age: 10
};

// 在浏览器环境中，window对象本身就有一个成员叫 name，所以在ts中不能再使用name
let {name: nickname, age} = user; // 等同于 var nickname = user.name, age = user.age

// 数组按照顺序解构，对象按照属性名解构

// 3.函数解构
function add(x: number, y: number){
    return x + y;
}
add(10,20);


function add([x1, y1]): number{
    return x1 + y1;
}
add([10,20]);

//4. 剩余参数
// 当不确定有几个参数的时候，可以用...的方式声明
function sum (...args: number[]){
    let res = 0;
    args.forEach(function (item){
        res += item;
    });
}
sum(1,2,3,4); //在调用的是，不需要给定数组，只需要输入每个值即可，在入参处可以将其解构成数组

//5. 数组展开操作符
let arr1 = [1,2,3];
let arr2 = [4,5,6];
arr2 = [4,5,6, ...arr1]; // 将arr1接在了arr2的后面

let arr3 = [...arr1,...arr2]; //将arr1和arr2两个数组拼接在一起

//6. 对象展开操作符
let obj1 = { foo: 'bar'}
let obj2 = { ...obj1, name: 'jack'} // 此时obj2除了有Name属性外还拥有了Obj1的所有属性

//7. 接口
interface IPerson {   //接口的定义，只包含属性和抽象方法
    firstName:string, 
    lastName:string, 
    sayHi: ()=>string //抽象方法的定义
} 
 
var customer:IPerson = {  //实现接口
    firstName:"Tom",
    lastName:"Hanks", 
    sayHi: ():string =>{return "Hi there"} //实现抽象方法
} 
 
console.log("Customer 对象 ") 
console.log(customer.firstName) 
console.log(customer.lastName) 
console.log(customer.sayHi())  
 
var employee:IPerson = { 
    firstName:"Jim",
    lastName:"Blakes", 
    sayHi: ():string =>{return "Hello!!!"} 
} 
 
console.log("Employee  对象 ") 
console.log(employee.firstName) 
console.log(employee.lastName)