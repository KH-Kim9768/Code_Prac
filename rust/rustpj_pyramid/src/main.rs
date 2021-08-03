/*
입력 받은 2개의 숫자가 높이와 기울기가 되는 피라미드 만들기
예)
입력)
3 2

출력)
   #
  ###
 #####

   #
  ####
#######

  #
 ###
#####
*/

use std::io;

fn main() {
    loop{

        // 수 입력 받음
        println!("Please Input 2 numbers : ");
        
        // 입력 받은 수 담을 변수
        let mut inputString = String::new();
        
        // 입력 받은 수 변수에 담음
        io::stdin().read_line(&mut inputString).expect("Wrong input");
        let mut splitString: Vec<&str> = inputString.split(' ').collect();

        let height = &splitString[0];
        let lean = &splitString[1];

        let height: u32 = match height.trim().parse(){
            Ok(x) => x,
            Err(_) => continue,
        };

        let lean: u32 = match lean.trim().parse(){
            Ok(x) => x,
            Err(_) => continue,
        };

        let max: u32 = (height - 1) * lean + 1;
        let mut blank: u32 = max / 2;
        let mut count: u32 = 1;
        
        loop{
            for i in (0..blank){
                print!(" ");
            }

            for i in (0..count){
                print!("#");
            }
            println!();

            if count == max {
                break;
            }

            count = count + lean;
            blank = blank - (lean / 2);

        }


    }
}
