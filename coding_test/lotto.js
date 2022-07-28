function solution(lottos, win_nums) {
  let answer = [];

  const score = {
    '0' : 6,
    '1' : 6,
    '2' : 5,
    '3' : 4,
    '4' : 3,
    '5' : 2,
    '6' : 1
  };

  let winCount = 0;
  let zeroCount = 0;

  lottos.forEach(element => {
    if (element == 0) {
      zeroCount += 1;
    } else {
      if (win_nums.includes(element)) {
        winCount += 1;
      }
    }
  });

  answer.push(score[winCount + zeroCount]);
  answer.push(score[winCount]);
  return answer;
}

solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]);