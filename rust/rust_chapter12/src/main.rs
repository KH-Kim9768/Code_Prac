use std::env;
use std::process;

use rust_chapter12::Config;

fn main() {
    let args: Vec<String> = env::args().collect();

    // let (query, filename) = parse_config(&args);

    // let config = parse_config(&args);
    let config = Config::new(&args).unwrap_or_else(|err| {
        println!("Problem parseing arguments : {}", err);
        process::exit(1);
    });

    println!("Searching for {}", config.query);
    println!("In file {}", config.filename);

    if let Err(e) = rust_chapter12::run(config){
        println!("Application error : {}", e);

        process::exit(1);
    }
    
}
