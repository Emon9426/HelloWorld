//for-of循环
// 几种循环：
// for | forEach(中途不能break) | for in(把数组当作对象来遍历) | for of
let arr6: number[] = [1,2,3];
//arr6.forEach
for (let key in arr6){  //for in循环循环的为index值而非数组的内容
    console.log(key);
}

for (let key of arr6){  //for of循环的是数组的内容
    console.log(key);
    if (key === 2){
        break;          //for of循环支持break
    }
}