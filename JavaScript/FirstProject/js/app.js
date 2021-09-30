// alert("hi");
let x = 10;
let y = 5;
const myName = "KKh";
let veryLingVariableName = 0;

console.log(x+y);
console.log(x*y);
console.log(x-y);
console.log(x/y);
console.log("hello " + myName);

const asd = true;
const nullvar = null;
let undefvar; // undefined

const mon = "mon";
const tue = "tue";
const wed = "wed";
const thu = "thu";
const fri = "fri";
const sat = "sat";
const sund = "sund";

const daysOfWeek = [mon, tue, wed, thu, fri, sat];

const nonsense = [1, 2, "hello", true, false, null, undefined, "kkh"];

// Get Item from Array
console.log(daysOfWeek[2]);

// Add one more day to the array
daysOfWeek.push(sund);
console.log(daysOfWeek);

const toBuy = ["potato", "tomato", "pizza"];
toBuy.push("kimbab");

const player = {
    name : "kkh",
    points : 124213,
    login : false,
    sayHello : function(name){
        console.log("Hello! my name is " + name);
    }

};

console.log(player);
console.log(player.name);
console.log(player["name"]);

player.lastName = "poatato";
console.log(player);

function sayHello(name, age) {
    console.log("Hello! my name is " + name + age);
}

sayHello("kkh", 25);
sayHello("KH", 25);

function plus(a, b) {
    const result = a + b;
    return result;
}

const result = plus(10, 20);
console.log(result);

function divide(a, b){
    console.log(a / b);
}
divide(10, 5);
player.sayHello("KKH");

// 나이 물어보기
// const age = prompt("How old are you?");

const age = parseInt("25");
console.log(isNaN(age))

if (age > 25){
    console.log("25 up");
} else if (age == 25){
    console.log("This is 25");
} else {
    console.log("25 down")
}