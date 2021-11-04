

static mut HELLO_WORLD: &str = "Hello, world!";

#[derive(Debug)]
enum Status {
    Value(u32),
    Stop,
}

fn main() {

    let list_of_statuses: Vec<Status> = (0u32..20).map(Status::Value).collect();
    let itr = list_of_statuses.iter();
    for i in itr{
        println!("{:?}", i);
    }

    // unsafe{
    //     println!("name is : {}", HELLO_WORLD);
    // }
    

    // let mut num = 5;

    // unsafe{
    //     let r1 = &num as *const i32;
    //     let r2 = &mut num as *mut i32;

    //     println!("{:?}, {:?}", *r1, *r2);
    // }
    
}
