fn main() {
    // let four = IpAddrKind::V4;
    // let six = IpAddrKind::V6;

    // let home = IpAddr{
    //     kind: IpAddrKind::V4,
    //     address: String::from("127.0.0.1"),
    // };

    // let loopback = IpAddr{
    //     kind: IpAddrKind::V6,
    //     address: String::from("::1"),
    // };

    // let home = IpAddrKind::V6(String::from("::1"));
    // let home1 = IpAddrKind::V4(127, 0, 0, 1);

    // let some_number = Some(5);
    // let absent_number: Option<i32> = None;
    
    // let five = Some(5);
    // let six = plus_one(five);
    // let none = plus_one(None);
    
    // let some_u8_value = 0u8;
    // match some_u8_value{
    //     1 => println!("one"),
    //     3 => println!("three"),
    //     5 => println!("five"),
    //     7 => println!("seven"),
    //     _ => println!("others"),
    // }

    let some_u8_value = Some(0u8);
    match some_u8_value {
        Some(3) => println!("three"),
        _ => (),
    }
    if let Some(3) = some_u8_value{
        println!("three");
    }
}


fn plus_one(x: Option<i32>) -> Option<i32>{
    match x{
        None => None,
        Some(i) => Some(i+1),
    }
}

enum Coin{
    Penny,
    Nickel,
    Dime,
    Quarter(UsState),
}
#[derive(Debug)]
enum UsState{
    Alabama,
    Alaska,
}

fn value_in_cents(coin: Coin) -> u32 {
    match coin{
        Coin::Penny => {
            println!{"Lucky Penny!"};
            1
        },
        Coin::Nickel => 5,
        Coin::Dime => 10, 
        Coin::Quarter(stateDAta) => {
            println!("State quater form{:?}", stateDAta);
            25
        },
    }
}

// enum IpAddrKind{
//     V4(u8, u8, u8, u8),
//     V6(String),
// }

// struct IpAddr{
//     kind: IpAddrKind,
//     address: String,
// }



// enum Message {
//     Quit,
//     Move { x: i32, y: i32},
//     Write(String),
//     ChangeColor(i32, i32, i32),
// }
// impl Message {
//     fn call(&self){
//        println!("" );
//     }
// }

