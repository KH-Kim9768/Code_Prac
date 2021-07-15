fn main() {
    // 변수와 가변성
    //----------------------
    /*
    let mut x = 6;
    println!("The value of x is : {}", x);

    x = 5;
    println!("the value of x is : {}", x);
    */
    
    // const MAX_POINTS: u32 = 100_000;
    
    /*
    let x = 5; 
    let x = x + 1;
    let x = x * 2;

    let mut y = 2;
    y = y + 1;
    y = y * 3;

    let y = y + 1 ;

    println!("The value of x is: {}", x);
    println!("The value of y is: {}", y);
    */
    /*
    let spaces = "     ";
    let spaces = spaces.len();

    println!("The value of spaces is : {}", spaces);

    */

    /*
    let mut spaces = "      ";
    spaces = spaces.len();
    // 컴파일 시 에러 발생, spaces 변수의 타입이 맞지 않기 때문에
    */

    // 데이터 타입들
    //-----------------------------------
    // rust는 타입이 고정된 언어
    /*
    let guess: u32 = "42".parse().expect("Not a Number");
    // u32 타입을 명시하지 않으면 컴파일 에러 발생
    */

    /*
    스칼라 --> 하나의 값으로 표현되는 타입,
    정수형, 부동소수점 숫자, boolean, 문자 총 4가지의 스칼라 타입을 보유
    
    rust의 정수형 리터럴들
    Decimal --> 98_222
    Hex --> 0xff
    Octal --> 0o77
    Binary --> 0b1111_0000
    Byte(u8 only) --> b'A'
    */
    /*
    부동 소수점 타입, 기본타입은 f64 (최신 CPU상에선 f64가 f32와 대략
    비슷한 속도를 내면서도 더 정밀한 표현이 가능하기 때문이다.)
    let a = 2.0; // f64 type
    let b: f32 = 3.0; // f32 type
    */
    
    /*
    // rust의 기본 연산자
    let sum = 5 + 10;

    let difference = 95.5 - 4.3;

    let product = 4 * 30;

    let quotient = 56.7/32.2;

    let remainder = 43%5;

    println!("sum : {}, difference : {}, product : {}, \nquotient : {}, remainder : {}",
        sum, difference, product, quotient, remainder);
    
    */

    /*
    // boolean 타입
    let t = true;
    let f: bool = false;
    

    // char은 작은 따옴표, String은 큰 따옴표를 사용한다.
    let c = 'z';
    let s = "Hello";
    */
    /*
    // 복합 타입
    // 튜플 --> 모든 값의 타입이 같지 않아도 됨
    let tup: (i32, f64, u8) = (500, 6.4, 1);

    let (x, y, z) = tup;
    
    let first_tup = tup.0;
    let second_tup = tup.1;
    let third_tup = tup.2;

    // 배열 --> 모든 값의 타입이 같아야 함
    // 배열은 항상 고정된 숫자의 요소를 갖는 경우에 쓰이면 좋음 (예: 달력 등)
    let list = [1, 2, 3, 4, 5];
    let first_list = list[0];
    let seconed_list = list[1];
    */
    
    

}