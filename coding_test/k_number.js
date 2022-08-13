/*
예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
*/

function solution(array, commands) {
  let answer = [];

  commands.forEach(command => {
    const start = command[0];
    const end = command[1];
    const numberIndex = command[2] - 1;

    const slicedArray = array.slice(start - 1, end).sort((a, b) => a - b);
    
    answer.push(slicedArray[numberIndex]);
  });

  return answer;
}

console.log(solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]));