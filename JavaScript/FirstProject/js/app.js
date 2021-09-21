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

};

console.log(player);
console.log(player.name);
console.log(player["name"]);

player.lastName = "poatato";
console.log(player);
