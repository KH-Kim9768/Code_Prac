function solution(numbers) {
  let answer = [];

  for (i = 0; i < numbers.length - 1; i++) {
    for (j = i + 1; j < numbers.length; j++) {
      answer.push(numbers[i] + numbers[j]);
    }
  }

  answer = [... new Set(answer)].sort((a,b) => a - b);

  return answer;
}