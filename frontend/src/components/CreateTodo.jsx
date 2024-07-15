import { useState } from "react"

export function CreateTodo(props) {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    return <div>
        <input type="text" placeholder="title" onChange={function(e){
            setTitle(e.target.value);
        }}/> <br />
        <input type="text" placeholder="description" onChange={function(e){
            setDescription(e.target.value);
        }}/> <br />
        <button onClick={() => {
            fetch("http://localhost:8080/api/v1/todo", {
                method: "POST",
                body: JSON.stringify({
                    title: title, 
                    description: description,
                    completed: false
                }),
                headers: {
                    "Content-type": "application/json"
                }
            }).then(function(res) {
                props.setTodos([...props.todos, {
                    title: title,
                    description: description,
                    completed: false
                }])
            })
        }}>Add a todo</button>
    </div>
}