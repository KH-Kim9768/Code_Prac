const images = [
    "00.jpg",
    "01.jpg",
    "02.jpg"
];

const chosenImage = images[Math.floor(Math.random() * images.length)];


const bgImage = document.createElement("img"); // img 요소를 생성
bgImage.src = `../img/${chosenImage}`;

document.body.appendChild(bgImage); // 생성된 img를 body에 추가

console.log(chosenImage);