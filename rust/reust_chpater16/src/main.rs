use std::thread;
use std::time::Duration;
use std::sync::mpsc;

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

    let (tt, rr) = mpsc::channel();
    
    thread::spawn(move || {
        let val = String::from("hi");
        tt.send(val).unwrap();
    });

    // let received = rr.recv().unwrap();
    for received in rr{
        println!("Got : {}", received);
    }
    
    
}
