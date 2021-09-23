use std::thread;
use std::time::Duration;

fn main() {
    
    // let simulated_user_specified_value = 10;
    // let simulated_random_number = 7;

    // generate_workout(simulated_user_specified_value, simulated_random_number);

    // let x =  vec![1,2,3];
    // let equal_to_x = |z| z == x;
    // let y = vec![1,2,3];

    // println!("can't use x here : {:?}", x);

    // assert!(equal_to_x(y));

    let v1 = vec![1, 2, 3];
    // let v1_iter = v1.iter();

    // for val in v1_iter{
    //     println!("Got : {}", val);
    // }

    let v2: Vec<_> = v1.iter().map(|x| x + 1).collect();
    assert_eq!(v2, vec![2, 3, 4]);

}

// fn simulated_expensive_calculation(intensity: u32) -> u32 {
//     println!("calculating slowly....");
//     thread::sleep(Duration::from_secs(2));
//     intensity
// }

fn generate_workout(intensity: u32, random_number: u32){
    
    // let expensive_closure = |num: u32| {
    //     println!("calculating slowly.....");
    //     thread::sleep(Duration::from_secs(2));
    //     num
    // };
    
    let mut expensive_result = Cacher::new(|num| {
        println!("calculating slowly.....");
        thread::sleep(Duration::from_secs(2));
        num
    });

    if intensity < 25 {
        println!(
            "Today, do {} pushups!",
            expensive_result.value(intensity)
        );
        
        println!(
            "Next, do {} situps!",
            expensive_result.value(intensity)
        );

    } else {
        if random_number == 3{
            println!("Take a break today! Remember to stay hydrated!");

        } else {
            println!(
                "Today, run for {} minutes!",
                expensive_result.value(intensity)
            );
        }
    }
}

struct Cacher<T>
where T: Fn(u32) -> u32,
{
    calculation: T,
    value: Option<u32>,
}

impl <T> Cacher<T> 
where T: Fn(u32) -> u32, 
{
    fn new(calculation: T) -> Cacher<T>{
        Cacher {
            calculation,
            value: None,
        }
    }

    fn value(&mut self, arg: u32) -> u32{
        match self.value{
            Some(v) => v,
            None => {
                let v = (self.calculation)(arg);
                self.value = Some(v);
                v
            }
        }
    }
}

#[derive(PartialEq, Debug)]
struct Shoe{
    size: u32,
    style: String,
}

fn shoes_in_size(shoes: Vec<Shoe>, shoe_size: u32) -> Vec<Shoe>{
    shoes.into_iter().filter(|s| s.size == shoe_size).collect()
}


struct Counter{
    count: u32,
}

impl Counter{
    fn new() -> Counter {
        Counter { count: 0 }
    }
}

impl Iterator for Counter{
    type Item = u32;
    
    fn next(&mut self) -> Option<Self::Item>{
        if self.count < 5{
            self.count += 1;
            Some(self.count)
        } else {
            None
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn filters_by_size(){
        let shoes = vec![
            Shoe{
                size: 10,
                style: String::from("sneaker"),
            },
            Shoe{
                size: 13,
                style: String::from("sandal"),
            },
            Shoe{
                size: 10,
                style: String::from("boot"),
            },
        ];

        let in_my_size = shoes_in_size(shoes, 10);

        assert_eq!(
            in_my_size,
            vec![
                Shoe{
                    size: 10,
                    style: String::from("sneaker"),
                },
                Shoe{
                    size: 10,
                    style: String::from("boot"),
                },
            ]
        );
    }

    #[test]
    fn using_other_iterator_trait_mathods() {
        let sum: u32 = Counter::new()
        .zip(Counter::new().skip(1))
        .map(|(a, b)| a * b)
        .filter(|x| x & 3 == 0)
        .sum();

        assert_ne!(18, sum);
    }
}