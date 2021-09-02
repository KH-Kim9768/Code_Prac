// main() start
fn main() {
    let number_list = vec![34, 50, 25, 100, 65];
    
    let result = largest(&number_list);
    println!("{}", result);

    let char_list = vec!['y', 'm', 'a', 'q'];
    let result = largest(&char_list);
    println!("{}", result);

    let p = Point{ x : 5,  y : 10};
    println!("p.x = {}", p.x());

    let p1 = Point1{
        x: 5,
        y: 10.4,
    };

    let p2 = Point1{
        x: "Hello",
        y: 'c',
    };

    let p3 = p1.mixup(p2);

    println!("p3.x = {}, p3.y = {}", p3.x, p3.y);

    let tweet = Tweet{
        username: String::from("KKh"),
        content: String::from(
            "of course, as you probably already know, people",
        ),
        reply: false,
        retweet: false,
    };

    println!("new tweet : {}", tweet.summarize());

    notify(&tweet);
    notify1(&tweet);
}
// main() end

fn largest<T: PartialOrd + Copy>(list: &[T]) -> T{
    let mut largest = list[0];

    for &item in list {
        if item > largest {
            largest = item;
        }
    }
    largest
}

struct Point<a>{
    x : a,
    y : a,
}

impl<a> Point<a>{
    fn x(&self) -> &a{
        &self.x
    }
}

struct Point1<T, U>{
    x: T,
    y: U,
}

impl<T, U> Point1<T, U>{
    fn mixup<V, W>(self, other: Point1<V, W>) -> Point1<T, W>{
        Point1{
            x: self.x,
            y: other.y,
        }
    }
}


pub trait Summary{
    fn summarize_author(&self) -> String;

    fn summarize(&self) -> String{
        format!("(Read more from {}...)", self.summarize_author())
    }
}

pub struct NewsArticle{
    pub headline: String,
    pub location: String,
    pub author: String,
    pub content: String,
}

impl Summary for NewsArticle{
    fn summarize_author(&self) -> String {
        format!("author is {}", &self.author)
    }
}

pub struct Tweet{
    pub username: String,
    pub content: String,
    pub reply: bool,
    pub retweet: bool,
}
impl Summary for Tweet{
    fn summarize_author(&self) -> String {
        format!("@{}", self.username)
    }
}

pub fn notify(item: &impl Summary){
    println!("notify Breaking news! {}", item.summarize());
}

pub fn notify1<T>(item: &T)
where T: Summary // 메소드 시작 전에 선언
{
    println!("notify1 Breaking news! {}", item.summarize());
}

// 다중 특성 경계 지정
// pub fn notify<T: Summary + Display>(item: &T)
// pub fn notify(item: &(impl Summary + Display))


