//函数
function add5(x: number, y: number): number{
    return x + y;
}

//函数的可选参数
function add51(x: number, y?: number): number {
    return x + 10;
}

//函数的默认参数
function add52(x: number, y: number = 20): number {
    return x + y;
}

//剩余参数(同03.ts)
function sum5(...args: number[]): number {
    let ret: number = 0;
    args.forEach((item: number): void =>{
        ret += item;
    })
    return ret;
}
// 当不确定入参有几个的时候，入参可以使用剩余参数，调用时，会自动将入参变成数组
sum5(1,2,4,5)

// 箭头函数
let add53 = (x: number, y:number): number => x + y;
// 函数名: add53
// 参数列表: (x: number, y:number)
// 返回值类型: number
// 函数体: x + y