fn main() {
    

    /*
    let mut s = String::from("hello");
    s.push_str(", world!");
    
    let s1 = s;

    let s2 = s1.clone();
    
    // println!("{}", s);
    println!("{}", s1);
    println!("{}", s2);
    */

    let s1 = String::from("hello");
    let len = calculate_length(&s1);

    println!("The length of '{}' is {}", s1, len);

    let mut s = String::from("hello");
    change(&mut s);

    let reference_to_nothing = no_dangle();

    let s = String::from("hello world");

    let hello = &s[0..5];
    let world = &s[6..11];
    
    println!("{}, {}", hello, world);


}

fn calculate_length(s: &String) -> usize {
    s.len()
}

fn change(some_string: &mut String){
    some_string.push_str(", world");
}

/*
fn dangle() -> &String{
    
    let s = String::from("hello");

    &s
}   // 여기서 s는 메모리에서 사라진다. 이 함수는 s를 반환하므로 오류가 발생한다.
*/

fn no_dangle() -> String{
    let s = String::from("hello");

    s
}

fn first_world(s: &String) -> usize{
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate(){
        if item == b' '{
            return i;
        }
    }

    s.len()
}