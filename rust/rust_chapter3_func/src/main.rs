use std::u32;

fn main() {
    /*
    println!("Hello, world!");

    new_function("kh", 1111);

    fn new_function(x: &str, y: u32){
        println!("new function {} {}", x, y);
    }
    // 매개변수의 default 값 설정 하는법???
    */

    /*
    let x = 1;
    let y = {
        let x = 3;
        println!("The value of x is {}", x);
        x + 1
    };

    println!("The value of x is {}", x);
    println!("The value of y is : {}", y);
    */


    fn five() -> i32 {
        5
    }

    fn plus_one(x: i32) -> i32 {
        x + 1
    }

    let x = five();
    let plus_x: i32 = plus_one(x);
    let plus_five: i32 = plus_one(five());

    println!("The value of x is : {}", x);
    println!("The value of plus_x is : {}", plus_x);
    println!("The value of plus_five is : {}", plus_five);

}
