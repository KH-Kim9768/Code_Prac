fn main() {
    
}

struct LinkedList<T, U>{
    data: T,
    link: U
}

impl <T, U>LinkedList<T, U>{
    fn link_node<V, W>(self, node: &LinkedList<V, W>) -> LinkedList<T, W>
    {
        LinkedList { data: self.data, link: node.self }
    }
}
