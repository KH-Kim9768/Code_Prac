use std::fs::File;
use std::io::ErrorKind;

fn main() {

    let f = File::open("hello.txt");

    let f = match f {
        Ok(file) => file,
        Err(error) => match error.kind() {
            ErrorKind::NotFound => match File::create("hello.txt"){
                Ok(fc) => fc,
                Err(er) => panic!("Create File Error : {:?}", er),
            },
            other_error => {
                panic!("Error : {:?}", other_error)
            }
        },
    };

    let f1 = File::open("hello1.txt").unwrap_or_else(|error| {
        if error.kind() == ErrorKind::NotFound{
            File::create("hello1.txt").unwrap_or_else(|error| {
                panic!("Create File Error {:?}", error);
            })
        } else {
            panic!("Something Error {:?}", error);
        }
    });

    let f2 = File::open("hello2.txt").expect("File Open Error");

    // panic!("crash and burn");
}
