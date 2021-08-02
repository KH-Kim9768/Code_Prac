fn main() {
    let rect1 = Rectangle{ length: 50, width: 30};
    println!("사각형의 넓이는 {}", area(&rect1));
    println!("rect1 is {:?}", rect1);
    println!("{}", rect1.areaRect());
}


// fn area(length: u32, width: u32) -> u32{
//     length * width
// }

// 튜플을 이용한 area 함수
// fn area(data: (u32, u32)) -> u32{
//     data.0 * data.1
// }

fn area(rect: &Rectangle) -> u32{
    rect.length * rect.width
}

#[derive(Debug)]
struct Rectangle{
    length: u32,
    width: u32,
}
impl Rectangle{ // 메소드
    fn areaRect(&self) -> u32{
        self.length * self.width
    }
}

struct User{
    username: String,
    email: String,
    sign_in_count:u64,
    active: bool,
}

struct consumer{
    name: String,
    email: String,
    sign_in_count: u64,
    active: bool,
}

// 튜플구조체
struct Color(i32, i32, i32);

fn build_user(email: String, username: String) -> consumer{
    consumer{
        name: username,
        email: email,
        active: true,
        sign_in_count: 1,
    }
}
