#[derive(Debug)]
enum List {
    Cons(Rc<RefCell<i32>>, Rc<List>),
    Nil,
}

use List::{Cons, Nil};
use std::rc::Rc;
use std::cell::RefCell;

fn main(){
    // let a = Rc::new(Cons(5, Rc::new(Cons(10, Rc::new(Nil)))));
    // println!("count after creating a = {}", Rc::strong_count(&a));
    // println!("count after creating a = {}", Rc::weak_count(&a));
    // let b = Cons(3, Rc::clone(&a));
    // println!("count after creating b = {}", Rc::strong_count(&a));
    // println!("count after creating b = {}", Rc::weak_count(&a));
    // {
    //     let c = Cons(4, Rc::clone(&a));
    //     println!("count after creating c = {}", Rc::strong_count(&a));
    //     println!("count after creating c = {}", Rc::weak_count(&a));
    // }
    
    // println!("count after c goes out of scope = {}", Rc::strong_count(&a));
    // println!("count after c goes out of scope = {}", Rc::weak_count(&a));
    
    let value = Rc::new(RefCell::new(5));

    let a = Rc::new(Cons(Rc::clone(&value), Rc::new(Nil)));
    
    let b = Cons(Rc::new(RefCell::new(6)), Rc::clone(&a));
    let c = Cons(Rc::new(RefCell::new(10)), Rc::clone(&a));

    *value.borrow_mut() += 10;
    println!("a after = {:?}", a);
    println!("b after = {:?}", b);

    *value.borrow_mut() -= 15;
    println!("c after = {:?}", c);

}




// // use List::{Cons, Nil};
// use std::ops::Deref;

// fn main() {
//     // let b = Box::new(5);
//     // println!("b = {}", b);

//     // let list = Cons(1, Box::new(Cons(2, Box::new(Cons(3, Box::new(Nil))))));

//     // let x = 5;
//     // let y = MyBox::new(x);

//     // assert_eq!(5, x);
//     // assert_eq!(5, *y);

//     // println!("{}", *y);

//     // let m = MyBox::new(String::from("Rust"));
//     // // &MyBox<String> --> &String --> &str
//     // hello(&m); // == hello(&(*m)[..])

//     // let c = CustomSmartPointer{data: String::from("my stuff")};
//     // drop(c);
//     // let d = CustomSmartPointer{data: String::from("other stuff")};
//     // println!("CustomSmartPointer created.");

// }   

// struct CustomSmartPointer{
//     data: String,
// }

// impl Drop for CustomSmartPointer {
//     fn drop (&mut self){
//         println!("Dropping CustomSmartPointer with data '{}' !", self.data);

//     }
// }

// fn hello(name: &str){
//     println!("Hello, {}!", name);
// }


// struct MyBox<T>(T);

// impl<T> MyBox<T>{
//     fn new(x: T) -> MyBox<T>{
//         MyBox(x)
//     }
// }

// impl<T> Deref for MyBox<T>{
//     // Deref 트레잇이 사용할 연관타입(associated type)을 정의
//     type Target = T;

//     fn deref(&self) -> &T{
//         &self.0
//     }
// }


// // enum List {
// //     Cons(i32, Box<List>),
// //     Nil,
// // }

