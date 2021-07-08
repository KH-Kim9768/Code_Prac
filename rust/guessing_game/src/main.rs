use std::io;    // std 표준 라이브러리 -> io 라이브러리 호출
use rand::Rng;

fn main() { // fn --> 새로운 함수 선언
    println!("Guess the number!");

    println!("Please Input your guess : ");
    
    let mut guess = String::new();  // let --> 변순 선언, mut --> 가변변수
    /* rust 에서 변수는 기본적으로 불변이기 때문에 변수 앞에 mut을 이용하여
     가변변수를 만든다 mutable <-> immutable(default) */
    
    io::stdin().read_line(&mut guess).expect("Failed to read line");
    /* use std::io가 없다면 std::io::stdio 로 작성 */

    println!("You guessed: {}", guess);
}