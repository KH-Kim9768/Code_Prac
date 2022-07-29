function solution(participant, completion) {
  const completionObject = {};

  completion.forEach(value => {
    if (completionObject[value] === undefined) {
      completionObject[value] = 1;
    } else {
      completionObject[value] += 1;
    }
  });

  participant.forEach(value => {
    if (typeof completionObject[value] == 'undefined' || completionObject[value] === 0) {
      answer = value;
      return;
    } else {
      completionObject[value] -= 1
    }
  });

  return answer;
}

console.log('result', solution(["leo", "kiki", "eden"], ["eden", "kiki"]))