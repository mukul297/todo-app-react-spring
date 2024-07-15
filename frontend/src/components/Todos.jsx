function updateByTitle(props, title) {
    props.setTodos(prevData => prevData.map(
        item => item.title === title ? { ...item, completed: true } : item
      ));
}

export function Todos(props) {
    
    return <div>
        {props.todos.map(function(todo) {
           return <div> 
            <h1>{todo.title}</h1>
            <h2>{todo.description}</h2>
            <button onClick={() => {
                updateByTitle(props,todo.title);
            }}>{todo.completed == true ? "Completed" : "Mark as Completed"}</button>
           </div>
        })}
    </div>
}    