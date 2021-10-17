
pub trait Draw{
    fn draw(&self);
}

pub struct Screen{
    pub components: Vec<Box<Draw>>,
}

impl Screen {
    pub fn run(&self){
        for component in self.components.iter(){
            component.draw();
        }
    }
}

fn main() {
    
}
