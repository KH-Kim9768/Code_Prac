const clock = document.querySelector("#clock");

// clock.innerText = "01:00";

function sayHello() {
    console.log("Hello!!");

}

// Interval == 주기적으로 실행하는 것 
setInterval(sayHello, 5000); // 5초마다 sayHello 함수를 실행,  초단위(ms)


function getClock() { 
    const date = new Date();

    // 자릿수 맞추는 함수 => padStart(자릿수, 빈자리 채울 문자)
    // const dateHour = date.getHours().toString().padStart(2, "0");
    const dateHour = String(date.getHours()).padStart(2, "0"); // 이렇게도 가능
    const dateMinute = date.getMinutes().toString().padStart(2, "0");
    const dateSecond = date.getSeconds().toString().padStart(2, "0");

    clock.innerText = `${dateHour} : ${dateMinute} : ${dateSecond}`;
    
}

// getClock() 실행 및 Interval 등록
getClock();
setInterval(getClock, 1000);
