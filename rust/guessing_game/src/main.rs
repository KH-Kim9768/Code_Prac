use std::io;    // std 표준 라이브러리 -> io 라이브러리 호출
use rand::Rng;
use std::cmp::Ordering;

fn main() { // fn --> 새로운 함수 선언
    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1..101);
    loop{
        println!("Please Input your guess : ");
    
        let mut guess = String::new();  // let --> 변순 선언, mut --> 가변변수
        /* rust 에서 변수는 기본적으로 불변이기 때문에 변수 앞에 mut을 이용하여
        가변변수를 만든다 mutable <-> immutable(default) */
        

        io::stdin().read_line(&mut guess).expect("Failed to read line");
        /* use std::io가 없다면 std::io::stdio 로 작성 */

        // let guess: u32 = guess.trim().parse().expect("Please type a number");
        let guess: u32 = match guess.trim().parse(){
            Ok(x) => x,
            Err(_) => continue,
        };
        // guess를 u32(int)로 변환하지 않으면 int와 string 은 비교를 할 수 없기 때문에
        // 오류가 발생한다.
        // trim --> 문자열의 앞 뒤 빈칸을 제거해준다 5 입력후 엔터 시 5\n 이 입력됨 --> trim이 \n 제거

        println!("You guessed: {}", guess);

        match guess.cmp(&secret_number){
            // Ordering의 열거 값 --> Less, Greater, Equal
            Ordering::Less => println!("TOO SMALL"),
            Ordering::Greater => println!("TOO BIG"),
            Ordering::Equal => {
                println!("YOU WIN");
                break;
            }
        }
    }

    println!("Bye");
}