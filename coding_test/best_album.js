function solution(genres, plays) {
  let answer = [];

  const rank = {};

  for (i = 0; i < genres.length; i++) {
    if (typeof rank[genres[i]] === 'undefined') {
      rank[genres[i]] = {
        albums: [],
        count: 0,
      };
    }

    rank[genres[i]].albums.push({
      id: i,
      play: plays[i],
    });
    rank[genres[i]].count += plays[i];
  }
  
  const sortedRank = Object.values(rank).sort((a, b) => b.count - a.count);

  sortedRank.map(value => {
    const sortedAlbums = value.albums.sort((a, b) => b.play - a.play).sort((a, b) => {
      if (a.play === b.play) {
        return a.id - b.id;
      }
    });
    
    answer.push(sortedAlbums[0].id);
    if (sortedAlbums.length > 1) answer.push(sortedAlbums[1].id);
  });

  return answer
}

console.log(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]));