/*
입력받은 숫자를 #을 이용해 출력
 */

use std::io;
fn main() {
    loop {
        println!("Please Input number : ");
        
        // 입력 받은 수 담을 변수
        let mut inputString = String::new();
        
        // 입력 받은 수 변수에 담음
        io::stdin().read_line(&mut inputString).expect("Wrong input");
        let inputString: i32 = match inputString.trim().parse(){
            Ok(x) => x,
            Err(_) => continue,
        };

        let mut numberVec: Vec<i32> = number_to_vec(inputString);

        // 변환된 숫자 벡터를 구조체로 변환
        let mut numStructVec: Vec<shapeNumber> = Vec::new();
        for i in &numberVec{
            numStructVec.push(transNumber(&i));
        }

        for i in &numStructVec{
            print!("{}", getHashTag(&i.first_line));
            printBlank();
        }
        println!();

        for i in &numStructVec{
            print!("{}", getHashTag(&i.second_line));
            printBlank();
        }
        println!();

        for i in &numStructVec{
            print!("{}", getHashTag(&i.third_line));
            printBlank();
        }
        println!();

        for i in &numStructVec{
            print!("{}", getHashTag(&i.fourth_line));
            printBlank();
        }
        println!();

        for i in &numStructVec{
            print!("{}", getHashTag(&i.fifth_line));
            printBlank();
        }
        println!();

        numberVec.clear();
        numStructVec.clear();
        
    }
    
}

fn number_to_vec(n: i32) -> Vec<i32> {
    let mut digits = Vec::new();
    let mut n = n;
    while n > 9 {
        digits.push(n % 10);
        n = n / 10;
    }
    digits.push(n);
    digits.reverse();
    digits
}

fn printBlank(){
    print!("   ");
}

fn transNumber(input_number: &i32) -> shapeNumber {
    
    match input_number{
        0 => shapeNumber{
            first_line: 0b111,
            second_line: 0b101,
            third_line: 0b101,
            fourth_line: 0b101,
            fifth_line: 0b111,
        },
        1 => shapeNumber{
            first_line: 0b010,
            second_line: 0b010,
            third_line: 0b010,
            fourth_line: 0b010,
            fifth_line: 0b010,
        },
        2 => shapeNumber{
            first_line: 0b111,
            second_line: 0b001,
            third_line: 0b111,
            fourth_line: 0b100,
            fifth_line: 0b111,
        },
        3 => shapeNumber{
            first_line: 0b111,
            second_line: 0b001,
            third_line: 0b111,
            fourth_line: 0b001,
            fifth_line: 0b111,
        },
        4 => shapeNumber{
            first_line: 0b101,
            second_line: 0b101,
            third_line: 0b111,
            fourth_line: 0b001,
            fifth_line: 0b001,
        },
        5 => shapeNumber{
            first_line: 0b111,
            second_line: 0b100,
            third_line: 0b111,
            fourth_line: 0b001,
            fifth_line: 0b111,
        },
        6 => shapeNumber{
            first_line: 0b100,
            second_line: 0b100,
            third_line: 0b111,
            fourth_line: 0b101,
            fifth_line: 0b111,
        },
        7 => shapeNumber{
            first_line: 0b111,
            second_line: 0b001,
            third_line: 0b001,
            fourth_line: 0b001,
            fifth_line: 0b001,
        },
        8 => shapeNumber{
            first_line: 0b111,
            second_line: 0b101,
            third_line: 0b111,
            fourth_line: 0b101,
            fifth_line: 0b111,
        },
        9 => shapeNumber{
            first_line: 0b111,
            second_line: 0b101,
            third_line: 0b111,
            fourth_line: 0b001,
            fifth_line: 0b001,
        },
        _ => shapeNumber{
            first_line: 0b111,
            second_line: 0b111,
            third_line: 0b111,
            fourth_line: 0b111,
            fifth_line: 0b111,
        },
    }
}

fn getHashTag(number: &i32) -> String{
    match number{
        0b001 => String::from("  #"),
        0b010 => String::from(" # "),
        0b011 => String::from(" ##"),
        0b100 => String::from("#  "),
        0b101 => String::from("# #"),
        0b110 => String::from("## "),
        0b111 => String::from("###"),
        _ => String::from("   "),
    }
}
struct shapeNumber{
    first_line: i32,
    second_line: i32,
    third_line: i32,
    fourth_line: i32,
    fifth_line: i32,
}
