fn main() {
    // 조건문
    /*
    let condition = true;
    let number = if condition{
        7
    } else {
        11
    };

    if number < 5 {
        println!("number : ~ 5");
    } else if number > 5 && number <10 {
        println!("number : 5 ~ 10");
    } else {
        println!("numver : 10 ~")
    }
    */

    // 반복문, 반복
    let mut number = 5;
    let a = [10, 20, 30, 40, 50];

    
    for element in a.iter(){
        println!("{}~", element);
    }
    
    for number in (1..4).rev(){ // 1 ~ 3 까지, .rev는 역순
        println!("{}", number);
    }

    while number != 0 {
        println!("{}!",number);
        number = number - 1 ;
    }
    
}
