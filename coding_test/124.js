function solution(n) {
  let answer = '';

  const convert = {
    '1': 1,
    '2': 2,
    '3': 4,
  };

  let remainders = [];
  while (n > 3) {
    let remainder = n % 3;
    if (remainder === 0) {
      n = parseInt(n / 3) - 1
      remainder = 3
    } else {
      n = parseInt(n / 3)
    }

    remainders.unshift(remainder);
  }
  remainders.unshift(n);

  remainders.map((value) => {
    return answer += convert[value];
  });

  return answer;
}

console.log(solution(1));
console.log(solution(2));
console.log(solution(3));
console.log(solution(4));
console.log(solution(5));
console.log(solution(6));
console.log(solution(7));
console.log(solution(8));
console.log(solution(9));
console.log(solution(10));
console.log(solution(11));