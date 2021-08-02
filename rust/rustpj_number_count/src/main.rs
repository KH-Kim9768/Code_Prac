/*
a b k를 입력받아 a와 b사이에 k가 몇번 들어가는지 출력하기
예) 입력 : 11 15 1    ---> 출력 : 6

필요한 내용
split 사용법 --> split 은 벡터로 변환 한다
// let mut strOrigin: Vec<&str> = "Hello World".split(' ').collect();
    
// let str1 = &strOrigin[0];
// let str2 = &strOrigin[1];
*/

use std::io;
fn main() {
    loop{
        // 수 입력 받음
        println!("Please Input 3 numbers : ");
        
        // 입력 받은 수 담을 변수
        let mut inputString = String::new();
        
        // 입력 받은 수 변수에 담음
        io::stdin().read_line(&mut inputString).expect("Wrong input");
        
        // 입력 받은 수 분할
        let mut splitString: Vec<&str> = inputString.split(' ').collect();
        
        // 분할 된 수 나눠 담기
        let mut startnum = &splitString[0];
        let mut endnum = &splitString[1];
        let mut findnum = &splitString[2];

        // 나눠 담은 string type의 수 u32로 변환
        let startnum: u32 = match startnum.trim().parse(){
            Ok(x) => x,
            Err(_) => continue,
        };

        let endnum: u32 = match endnum.trim().parse(){
            Ok(x) => x,
            Err(_) => continue,
        };
        
        let findnum: u32 = match findnum.trim().parse(){
            Ok(x) => x,
            Err(_) => continue,
        };

        let count = countNumber(startnum, endnum, findnum);
        
        
        println!("{} Number Count : {}", findnum, count);

        
    }
}

fn countNumber(start_num: u32, end_num: u32, find_num: u32) -> u32{
    let mut count_num = 0;
    for i in start_num..(end_num+1){
        let mut current_num = i;
        loop {
            if current_num % 10 == find_num{
                count_num = count_num + 1;
            }

            if current_num / 10 == 0{
                break;
            } else{
                current_num /= 10;
            }
            
        }
    }

    count_num
}

