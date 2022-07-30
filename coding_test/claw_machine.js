function solution(board, moves) {
  let answer = 0;

  const results = [];

  const boardRotate = [];
  for (i = 0; i < board.length; i++) {
    const row = [];
    for (j = 0; j < board.length; j++) {
      if (board[j][i] !== 0) {
        row.unshift(board[j][i]);
      }
    }
    boardRotate.push(row);
  }

  moves.forEach(value => {
    if (boardRotate[value - 1].length > 0) {
      const item = boardRotate[value - 1].pop();
      if (results.length > 0) {
        if (results[results.length - 1] === item) {
          results.pop();
          answer += 2;
        } else {
          results.push(item);
        }
      } else {
        results.push(item)
      }
    }
  });

  return answer;
}

console.log(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4]));