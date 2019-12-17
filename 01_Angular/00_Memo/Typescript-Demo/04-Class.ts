//1. 类的声明
class Person{
    // 类的属性必须要提前实现并且指定类型
    name: string;
    age: number;
    type: string = '人类'; //可以在声明类成员的同时为其赋值
    // 访问修饰符
    //    3-1. public 默认 共有的
    //    3-2. private 私有的
    //    3-3. protected 被保护的，和私有的一样，但是可以被继承。只能在子类中访问，实例化的对象无法访问protect属性
    //    3-4. readonly 只读，不允许修改 ex private readonly type: string = '人类'，小伙和const一样
    private prvType: string = '人类';
    constructor (name: string, age: number) {
        //类的构造函数
        //当new persion时，会调用这个函数
        this.name = name;
        this.age = age;
    }


    // 实例方法
    sayHello(): void {
        console.log(this.age,this.name);
    }

    eat() {
        console.log('吃饭');
    }

    // 私有属性的访问
    public getType(){
        return this.prvType;
    }
}

//调用
let p1 = new Person('张三',18);
p1.sayHello();

//2. 继承
class Student extends Person {
    // 此时student 已经将person的成员继承过来
    constructor(name: string, age: number){
        super(name,age); //super意为调用父类的构造函数
    }
}

//new Student().时，可以看到person的所有属性和方法
//new Student('张三',18).age // 此时会将属性继承过来

//3. 类成员的访问修饰符
//new Person(). //此时可以访问这个类的所有成员，类的成员默认都是对外公开的(public)。
//在创建了prvType后，发现不能访问这个私有的属性，如果需要修改，需要用
new Person('张三',18).getType() //来访问
//类的私有成员无法被继承
//new Student(). //是看不到prvType的

//4. 使用构造函数简写声明
class Person1{
    name: string;
    age: number;
    constructor (name: string, age: number) {
        this.name = name;
        this.age = age;
    }
}
// 等价于
class Person2{
    constructor(public name: string, public age: number){}
}

//5. 类属性的存取器
class Person3 {
    private _age: number;    
    constructor(){}

    get age(){ return this._age;}         //读值用
    set age(val){if(val < 0){             //赋值用
        throw new Error('年龄不能为负数');
    }
    this._age = val;
    }
}
new Person3().age = 10;

//6. 静态成员
//只能通过类本身访问，实例是访问不到的
class Person4{
    static type: string  = '人类'; //静态成员 也叫类成员
    age: number = 18; //实例成员

    static sayHello() {
        console.log('Hello');
    }
}
//new Person4().// 找不到type这个成员
//Person4.type // 只能通过类访问之恶个属性
//new Person4().age //实例成员通过类的实例化对象来访问
//Person4.sayHello() // 静态方法的访问