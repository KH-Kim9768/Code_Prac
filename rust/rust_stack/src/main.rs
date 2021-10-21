use std::ops::Deref;


struct Node<T> {
    Data: T,
    Link: Option<Box<Node<T>>>,
}

struct Stack<T>{
    last: Option<Box<Node<T>>>,
}

impl<T> Stack<T>{
    fn new() -> Stack<T>{
        Stack { last: None }
    }

    fn push(&mut self, n: T){
        let tmp = self.last;
        self.last = Some(Box::new(Node { Data: n, Link: tmp }));
    }

    fn pop(&mut self) -> Option<T> {
        let result = self.last;
        let tmo = result.unwrap();
        let tm = *tmo;
        let tt = tm.Link;
        self.last = tt;
        


    }
}

fn main() {
    println!("Hello, world!");
}
