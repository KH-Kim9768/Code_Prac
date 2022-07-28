function solution(numbers) {
  let answer = 45;
  
  numbers.forEach(value => {
    answer -= value;
  })

  return answer;
}