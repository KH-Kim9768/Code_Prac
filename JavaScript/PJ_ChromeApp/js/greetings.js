// CSS CLASS NAME
const HIDDEN_CLASSNAME = "hidden";

// CONST VAR
const USERNAME_KEY = "username";

// Login Part
const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");
const greeting = document.querySelector("#greeting");


/// Login Btn Click function
function onLoginSubmit(event) {

    // 기본동작을 막는다 preventDefault()
    event.preventDefault();
    const username = loginInput.value;
    localStorage.setItem(USERNAME_KEY, username);

    loginForm.classList.add(HIDDEN_CLASSNAME);
    
    paintGreetings(username);
    
}

// Show Greetings
function paintGreetings(username){
    greeting.innerText = `Hello ${username}`; // "Hello " + username
    greeting.classList.remove(HIDDEN_CLASSNAME);
}

// ADD EVENTLISTNER
loginForm.addEventListener("submit", onLoginSubmit);


// Loading Username
const savedUserName = localStorage.getItem(USERNAME_KEY);
if (savedUserName == null) {
    // show the form
    loginForm.classList.remove(HIDDEN_CLASSNAME);

} else {
    // show the greetings
    paintGreetings(savedUserName);
}