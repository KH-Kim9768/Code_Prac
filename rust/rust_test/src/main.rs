use std::option::Option;

fn main() {
    
}

struct LinkedList<T>{
    data: T,
    link: Option<LinkedList<T>>
}

impl <T>LinkedList<T>{
    fn new(t: T) -> LinkedList<T>{
        LinkedList {data: t, link: None}
    }

    fn link_node(&mut self, data: T) -> LinkedList<T>
    {
        LinkedList { data: self.data, link: &LinkedList::new(data) }
        
    }
}
