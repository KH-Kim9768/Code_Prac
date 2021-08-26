fn main() {
    let str_1 = String::from("Hello World");

    print!("{:?}", str_1);

    let teams = vec![String::from("Blue"), String::from("Yellow")];

    let teamss = vec![String::from("Blue"), String::from("Yellow")];

    // for i in teams{
    //     print!("{}", i);
    // }

    let teams2 = vec![teams, teamss];

    for i in teams2{
        for j in i{
            print!("{}", j);
        }
    }
}
