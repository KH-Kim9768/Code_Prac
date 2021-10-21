enum Message{
    Hello{ id: i32},
}

fn main(){
    let msg = Message::Hello{id:5};

    match msg{
        Message::Hello{
            id: id @ 3..=7,
        } => println!("Found an id in range: {}", id),

        Message::Hello{id: 10..=12} => 
            println!("Found an id in another range"),
        

        Message::Hello{id} => println!("Found some other id : {}", id),
    }
}

// fn main(){
//     let s = Some(String::from("Hello!"));

//     if let Some(_) = s {
//         println!("found a string");
    
//     }

//     println!("{:?}", s);
// }



// enum Color {
//     Rgb(i32, i32, i32),
//     Hsv(i32, i32, i32),
// }

// enum Message {
//     Quit,
//     Move { x: i32, y: i32}, 
//     Write(String),
//     ChangeColor(Color),
// }

// fn main(){
//     let msg = Message::ChangeColor(Color::Hsv(0, 160, 255));

//     match msg {
//         Message::ChangeColor(Color::Rgb(r, g, b)) => println!("Change the color to red {}, green {}, and blue {}", r, g, b),
//         Message::ChangeColor(Color::Hsv(h, s, v)) => println!("Change the color to hue {}, saturation {}, and value {}", h, s, v),
//         _ => (),
//     }
// }


// struct Point<T>{
//     x: Option<T>,
//     y: i32,
// }

// fn main(){
//     let p = Point{ x: Some(0), y:7};

//     let Point{ x: a, y: b} = p;
//     println!("a = {}, b = {}", a.unwrap(), b);
//     println!("{}, {}", p.x.unwrap(), p.y);

    
// }


// fn print_coordinates(&(x, y): &(i32, i32)){
//     println!("Current location : ({}, {})", x, y);
// }

// fn main(){
//     let point = (3,5);
//     print_coordinates(&point);

//     let mut x = 5;
//     match x {
//         1 ..= 5 => println!("one ~ five"),
//         _ => println!("out of range"),
//     }

//     x = 6;
//     match x {
//         1 ..= 5 => println!("one ~ five"),
//         _ => println!("out of range"),
//     }
// }

// fn main() {
    
//     let mut stack = Vec::new();
//     stack.push(1);
//     stack.push(2);
//     stack.push(3);

//     while let Some(top) = stack.pop(){
//         println!("{}", top);
//     }

//     let v = vec!['a', 'b', 'c'];
//     for (index, value ) in v.iter().enumerate(){
//         println!("{} is at index {}", value, index);
//     }
// }
