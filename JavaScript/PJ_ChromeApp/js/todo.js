const toDoForm = document.getElementById("todo-form");
const toDoInput = toDoForm.querySelector("input"); // document.querySelector("#todo-form input")
const toDoList = document.getElementById("todo-list");

const toDos = [];


function handleToDoSubmit(event){
    event.preventDefault();
    const newTodo = toDoInput.value;
    toDoInput.value = "";
    toDos.push(newTodo);
    paintToDo(newTodo);
    saveToDos();
}

function paintToDo(newTodo){
    const li = document.createElement("li");
    const span = document.createElement("span");
    const button = document.createElement("button");

    
    span.innerText = newTodo;
    button.innerText="X";
    button.addEventListener("click", deleteToDo);
    
    li.appendChild(span);
    li.appendChild(button);    
    toDoList.appendChild(li);
}

function deleteToDo(event){
    const li = event.target.parentElement; // 클릭한 li 선택
    li.remove();
}

function saveToDos(){
    localStorage.setItem("todos", JSON.stringify(toDos));
}

toDoForm.addEventListener("submit", handleToDoSubmit);