fn main() {
    let s = String::from("Hello World");

    let hello = String::from(&s[0..5]);
    let world = &s[6..11];

    let s = String::from("Hello dlrow");
    
    println!("{}", hello);
    println!("{}", world);
    println!("{}", s);
}
