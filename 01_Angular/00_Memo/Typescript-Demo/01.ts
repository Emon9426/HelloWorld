/*
// .ts后缀为一个typescript文件

//变量定义
//Typescript是强类型，可以不定义数据的类型，但是一旦定义了变量的类型则不能动态修改
var foo: string = 'bar';
console.log(foo);

//关于对象
var user: {
    name: string,
    age: number
} = {
    name: 'Jack',
    age: 18
}

console.log(user.name);
console.log(user.age);

//需要先执行
//  tsc ./01.ts
//将ts文件编译成Js文件，然后执行Js文件
*/