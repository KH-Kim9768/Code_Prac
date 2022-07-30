function solution(s) {  
  return s.split(' ').map(value => {
    if (value.length > 0)
    return value.split('').map((value, index) => {
      if (index % 2 === 0) {
        return value.toUpperCase();
      } else {
        return value.toLowerCase();
      }
    }).join('');
  }).join(' ');
}