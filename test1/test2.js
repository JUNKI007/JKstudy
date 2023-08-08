// for(let i = 0; i < 10; i++){
//     if(i % 2 === 0){
//         alert(i + "짝수")
//     }else if(i % 2 !== 0){
//         alert(i + "홀수")
//     }else{
//         alert("??")
//     }
// }

// setInterval(()=>{
//     for(let i=0; i< 5;i++){
//         setTimeout(()=>{
//             console.log(i)
//         },1000 * i)
//     }
// },1000)


// setInterval(()=>{
//     console.log(new Date())
// },1000)

// while(true){
//     console.log(1)
// }

// switch (key) {
//     case value:
        
//         break;

//     default:
//         break;
// }

console.time("a")
const list = ["안", "녕", "하", "세", "요"];
for(let i=0;i<list.length;i++){
    console.log(list[i])
}
console.table(list)
console.timeEnd("a")

function test(){
    // alert("test")
}
test()

function sum(a, b){
    return a + b
}
const c = sum(1,2)
console.log(c)

const obj = {
    name:"park"
, age: 20
, p: sum
, m: function (a,b){
    return a-b
}}
const d =obj.p(1,2)
console.log(d)
console.log(obj.m(2,1))

function p1(pa){
    function p2(){
        function p3(p){
            pa = p + 200;
            return p + 200;
        }
        pa = 100;
        p = p3(pa)
        return p3(pa)
    }
    return p2()
}

let p = 0;
alert("fdsafdssda");
// console.log(p1(p), p)
// const list1 = [p1]
// console.log(list1[0](1))
// const 계산기 = [0, 플러스, 마이너스, 곱하기, 나누기]
// 계산기[2](1)