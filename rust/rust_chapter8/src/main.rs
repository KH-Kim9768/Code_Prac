use std::collections::HashMap;

fn main() {

    let mut scores = HashMap::new();

    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Yellow"), 50);

    let teams = vec![String::from("Blue"), String::from("Yellow")];
    let initial_scores = vec![10, 50];

    // zip 메소드를 이용하여 해시맵 만들기
    let mut scores: HashMap<_, _> = teams.into_iter().zip(initial_scores.into_iter()).collect();



    // 키가 입력되면 해시맵의 소유권입니다. 
    let field_name = String::from("Favorite color");
    let field_value = String::from("Blue");
    
    let mut map = HashMap::new();
    map.insert(field_name, field_value);
    

    let mut scores = HashMap::new();
    
    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Yellow"), 50);

    for (key, value) in &scores{
        println!("{} : {}", key, value);
    }

    
    // 값 덮어쓰기
    // 키에 값이 없는 경우에만 값이 삽입 된다.
    let mut scores = HashMap::new();

    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Blue"),60);
    println!("{:?}", scores);


    // 이전 값을 기반으로 값 업데이트
    // 같은 단어가 몇개 들어 있는지 체크하기
    let text = "hello world wonderful world";

    let mut map = HashMap::new();

    for word in text.split_whitespace(){
        let count = map.entry(word).or_insert(0);
        *count += 1;
    }
    
    println!("{:?}", map);


    /*
    let v: Vec<i32> = Vec::new();

    let v = vec![1,2,3];

    let mut v = Vec::new();
    v.push(5);
    v.push(6);
    v.push(7);
    v.push(8);

    let v = vec![1,2,3,4,5];

    let third: &i32 = &v[2];

    match v.get(2){
        Some(third) => println!("The third element is {}", third),
        None => println!("Ther is no third element."),
    }

    let v = vec![100, 32, 56];
    for i in &v{
        println!("{}", i);
    }

    let mut v = vec![100, 32, 47];
    for i in &mut v {
        *i += 50;
    }
    for i in &v{
        println!("{}", i);
    }

    */
}
