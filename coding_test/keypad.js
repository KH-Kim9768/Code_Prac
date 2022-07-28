const numberLocation = {
  '0' : [3, 1],
  '*' : [3, 0],
  '#' : [3, 2],
};

for (i = 1; i <= 9; i++) {
  numberLocation[i] = [parseInt((i - 1) / 3), (i - 1) % 3];
}

function solution(numbers, hand) {
  let answer = '';

  let leftState = '*';
  let rightState = '#';
  
  numbers.forEach(value => {
    let result = '';

    if (numberLocation[value][1] == 2) { 
      result = 'R';
    } else if (numberLocation[value][1] == 0) {
      result = 'L';
    } else {
      if (calcDistance(leftState, value) > calcDistance(rightState, value)) {
        result = 'R';
      } else if (calcDistance(leftState, value) < calcDistance(rightState, value)) {
        result = 'L';
      } else {
        if (hand == 'right') {
          result = 'R';
        } else {
          result = 'L';
        }
      }
    }

    if (result == 'R') { 
      rightState = value;
    } else {
      leftState = value;
    }
    answer += result;
    
  });

  return answer;
}

function calcDistance(state, value) {
  const stateLocation = numberLocation[state];
  const valueLocation = numberLocation[value];
  
  return Math.abs(stateLocation[0] - valueLocation[0]) + Math.abs(stateLocation[1] - valueLocation[1]);
}