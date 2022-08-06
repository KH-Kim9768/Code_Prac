/*

먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 
각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

*/

function solution(progresses, speeds) {
  let answer = [];
  
  while (progresses.length > 0) {
    let count = 0;
    
    let flag = true;
    for (let i = 0; i < progresses.length; i++) {
      progresses[i] += speeds[i];
      if (flag && progresses[i] >= 100) {
        count += 1;
      } else {
        flag = false;
      }
    }  
    
    if (count > 0) {
      answer.push(count);
      progresses.splice(0, count);
      speeds.splice(0, count);
    }
  }
  
  return answer;
}
