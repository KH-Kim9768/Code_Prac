use std::thread;
use std::time::Duration;
use std::sync::mpsc;
use std::sync::{Mutex, Arc};

fn main() {
    // thread::spawn(|| {
    //     for i in 1..10 {
    //         println!("hi number {} from the spawned thread!", i);
    //         thread::sleep(Duration::from_millis(1));
    //     }
    // }).join().unwrap();

    
    // for i in 1..5{
    //     println!("h1 number {} from the main thread!", i);
    //     thread::sleep(Duration::from_millis(1));
    // }

    // let (tt, rr) = mpsc::channel();
    
    // let tt1 = mpsc::Sender::clone(&tt);


    // thread::spawn(move || {
    //     // let val = String::from("hi");
    //     let vals = vec![
    //         String::from("hi"),
    //         String::from("from"),
    //         String::from("the"),
    //         String::from("thread"),
    //     ];

    //     for val in vals {
    //          tt.send(val).unwrap();
    //          thread::sleep(Duration::from_secs(1));
    //     }
        
        
    // });

    // thread::spawn(move || {
        
    //     let vals  = vec![
    //         String::from("more"),
    //         String::from("messages"),
    //         String::from("for"),
    //         String::from("you"),
    //     ];

    //     for val in vals{
    //         tt1.send(val).unwrap();
    //         thread::sleep(Duration::from_secs(1));
    //     }

    // });

    // for received in rr {
    //     println!("Got : {}", received);
    // }

    // let counter = Arc::new(Mutex::new(0));
    // let mut handles = vec![];

    // for _ in 0..10{
    //     let counter = Arc::clone(&counter);
    //     let handle = thread::spawn(move || {
    //         let mut num = counter.lock().unwrap();

    //         *num += 1;
    
    //     });
    //     handles.push(handle);
    // }

    // for handle in handles{
    //     handle.join().unwrap();
    // }

    // println!("Result : {}", *counter.lock().unwrap());
    
    let struct1 = CustomStruct{
        num1: 50,
        num2: 30,
    };
      

    let handle = thread::spawn(move || {
       println!("{:?}", struct1.num1);
       println!("{:?}", struct1.num2);
    });

    handle.join().unwrap();
}

struct CustomStruct {
    num1: i32,
    num2: i32,
}
