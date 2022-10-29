/**
 * 주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다. 
 * 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 * 
 * fees[0] = 기본 시간(분)
 * 1 ≤ fees[0] ≤ 1,439
 * fees[1] = 기본 요금(원)
 * 0 ≤ fees[1] ≤ 100,000
 * fees[2] = 단위 시간(분)
 * 1 ≤ fees[2] ≤ 1,439
 * fees[3] = 단위 요금(원)
 * 1 ≤ fees[3] ≤ 10,000
 */


function solution(fees, records) {
  let answer = [];
  const record = {};
  const [ defaultTime, defaultFee, unitMinute, unitFee ] = fees;

  records.forEach(value => {
    const [ time, carNumber, inOut ] = value.split(' ');
  
    if (!record[carNumber]) {
      record[carNumber] = {
        'IN' : [],
        'OUT' : []
      };
    }
    record[carNumber][inOut].push(time);
  });

  const sortedKeys = Object.keys(record).sort((a, b) => {
    return Number(a) - Number(b);
  });
  
  sortedKeys.forEach(value => {
    let totalFee = 0;
    let parkingTime = 0;
    const { IN, OUT } = record[value];

    IN.forEach((inTime, index) => {
      const outTime = OUT.length <= index ? '23:59' : OUT[index];
      parkingTime += diffTime(inTime, outTime);
    })

    const fee = defaultFee + (Math.ceil(getFeeTime(parkingTime, defaultTime) / unitMinute)) * unitFee;
    totalFee += fee;
    answer.push(totalFee);
  });

  return answer;
}

function diffTime(startTime, endTime) {
  const [ startHour, startMinute ] = startTime.split(':');
  const [ endHour, endMinute ] = endTime.split(':');
  
  const hourDiff = Number(endHour) - Number(startHour);
  const minuteDiff = Number(endMinute) - Number(startMinute);
  
  const result = (hourDiff * 60) + minuteDiff;
  
  return result;
}

function getFeeTime(time, defaultTime) {
  const result = time - defaultTime < 0 ? 0 : time - defaultTime;
  return parseInt(result);
}

console.log(solution([180, 5000, 10, 600], ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))
