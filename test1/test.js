 // 변수 선언
// var a = 1;
// b = 1;
// c = "1";
// d = '1232432442aaaa';
// let const
let a = 1;
let b = 2;
console.log(a + b);

const c = 1;
a = '2';
console.log(a + b);

// c = 5;
console.log(c); 

let isNumber = true;
let isNotNumber = false;
console.log(a === b);
console.log(a !== b);
console.log(a > b);

class Person{
    age;
    name;
    constructor(age, name){
        this.age = age;
        this.name = name;
    }
}
let p = new Person();
p.age = 10;
p.name = "aaaa";
console.log(p);

let p2 = new Person(20, "sfdf");
console.log(p2);

let obj = {"i": "fff"};
obj["name"] = "aaa";
obj["age"] = 20;
console.log(obj);
let key = "age";
console.log(obj.age);
console.log(obj["age"]);
console.log(obj[key]);

let list = [];
list.push("a");
list.push("b");
list.push(1);
list.push(obj);
list.push([]);
console.log(list);
console.log(list[2]);

obj["list"] = list;
console.log(obj.list2);
console.log(list[100]);

console.log(new Date());
console.log(new Date().getTime());
console.log(new Date(1));
let 하루전 = new Date(new Date().getTime() - 1000*60*60*24);
let 이일전 = new Date(new Date().getTime() - 1000*60*60*24*2);
let 한달전 = new Date();
한달전.setMonth(new Date().getMonth()-1);
console.log(한달전);


// setTimeout(()=>{
//     alert("ㅁㄴ1ㄴㄴ");
// }, 1000);