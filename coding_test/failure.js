function solution(N, stages) {
  let answer = [];

  const rate = [];
  
  for(i = 1; i <= N; i++) {
    const rateObject = {
      'stage': i,
      'rate': 0,
    };

    const users = stages.filter(value => {
      if (value === i) {
        rateObject.rate += 1
      }

      return value >= i;
    });

    rateObject.rate /= users.length;
    rate.push(rateObject);
  }

  rate.sort((a, b) => [
    b.rate - a.rate
  ]);
  
  answer = rate.map(value => value.stage);

  return answer;
}