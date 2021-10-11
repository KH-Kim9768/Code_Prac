const quotes = [
    {
        quote : "포기해야겠다는 생각이 들 때야 말로 성공에 가까워진 때이다",
        author : "밥 파슨스",
    },

    {
        quote : "꿈을 기록하는 것이 목표였던 적은 없다. 꿈을 실현하는 것이 나의 목표다.",
        author : "만레이",
    },

    {
        quote : "최고의 경쟁력은 열정이다.",
        author : "잭 웰치",
    },

    {
        quote : "가장 나답게 인생을 뛰어넘어야 한다. 그것이 내 삶의 주인으로 사는 법이다.",
        author : "센다 타쿠야",
    },

    {
        quote : "나는 10번 시도하면 9번 실패했다. 그래서 10번씩 시도했다.",
        author : "조지 버나드 쇼",
    },

    {
        quote : "우리가 진정으로 소유하는 것은 시간 뿐이다. 가진 것이 달리 아무 것도 없는 이에게도 시간은 있다.",
        author : "발타사르 그라시안",
    },

    {
        quote : "네 자신의 생활을 즐기라. 자신의 생활을 남과 견주어 보지 마라.",
        author : "꽁 도르세",
    },

    {
        quote : "내일은 우리가 어제로부터 무엇인가 배웠기를 바란다",
        author : "존 웨인",
    },

    {
        quote : "앞서 가는 방법의 비밀은 시작하는 것이다.",
        author : "마크트웨인",
    },

    {
        quote : "행운은 100퍼센트 노력한 뒤에 남는 것이다.",
        author : "랭스터 콜만",
    }
];



const quote = document.querySelector("#quote span:first-child"); // id = quote의 첫번째 span 속성
const author = document.querySelector("#quote span:last-child"); // 마지막 span 속성



// Math.floor(버림), Math.ceil(올림), Math.round(반올림)
const randomIndex = Math.floor(Math.random() * quotes.length);



quote.innerText = quotes[randomIndex].quote;
author.innerText = quotes[randomIndex].author;