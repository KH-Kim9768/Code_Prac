
// Login Part
const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");

/// Login Btn Click function
function onLoginSubmit(event) {
    // const username = loginInput.value;
    // console.log(username);
    event.preventDefault();
    console.log(loginInput.value);
    
}

loginForm.addEventListener("submit", onLoginSubmit);
