import { useState } from 'react'
import './App.css'
import { CreateTodo } from './components/CreateTodo'
import { Todos } from './components/Todos'

function App() {
  const [todos, setTodos] = useState([]);

  return (
    <div>
      <CreateTodo todos={todos} setTodos={setTodos}></CreateTodo>
      {/* rendering */}
      <Todos todos={todos} setTodos={setTodos}></Todos>
    </div>
  )
}

export default App
