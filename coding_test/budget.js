function solution(d, budget) {
  let answer = 0;

  const department = d.sort((a, b) => a - b);
  
  department.forEach(value => {
    budget -= value;
    if (budget < 0) {
      return;
    } else {
      answer += 1;
    }
  });
  
  return answer;
}