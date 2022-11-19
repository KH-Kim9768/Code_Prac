/*
number	limit	power	result
5	3	2	10
10	3	2	21
*/

function solution(number, limit, power) {
  var answer = 0;

  for (let i = 1; i <= number; i++) {
    const divisorLength = getDivisor(i);
    if (divisorLength > limit) {
      answer += power;
    } else {
      answer += divisorLength
    }
  }

  return answer;
}

function getDivisor(number) {
  let result = 0

  for (let divNum = 1; divNum * divNum <= number; divNum++) {
    if (divNum * divNum === number) {
      result += 1;
    } else if (number % divNum === 0) {
      result += 2;
    }
  }

  return result;
}

console.log(solution(5, 3, 2))
console.log(solution(10, 3, 2))