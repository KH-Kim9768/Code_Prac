function solution(nums) {
  let answer = 0;
  const count = parseInt(nums.length / 2);
  
  const pokemons = [...new Set(nums)];
  
  answer = count > pokemons.length ? pokemons.length : count;
  
  return answer;
}