import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


interface ToDo {
  id: number;
  title: string;
  description: string;
  completed: boolean;
  createdDate:Date;
}

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  
  todos: ToDo[] = [];
  searchTerm: string = '';
  sortOrder: string = '';
  newTodo: ToDo = {
    id: 0,
    title: '',
    description: '',
    completed: false,
    createdDate:new Date()
  };

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getTodos();
  }

  getTodos() {
    this.http.get<ToDo[]>('http://localhost:8080/api/todos')
      .subscribe(data => this.todos = data);
  }

  

  createTodo() {
    this.http.post<ToDo>('http://localhost:8080/api/todos', this.newTodo)
      .subscribe(todo => {
        this.todos.push(todo);
        this.newTodo = { id: 0, title: '', description: '', completed: false, createdDate:new Date };
      });
  }

  updateTodoStatus(todo: ToDo) {
    this.http.put<ToDo>(`http://localhost:8080/api/todos/${todo.id}`, todo)
      .subscribe(updatedTodo => {
        const index = this.todos.findIndex(t => t.id === updatedTodo.id);
        this.todos[index] = updatedTodo;
      });
  }

  deleteTodo(id: number) {
    this.http.delete(`http://localhost:8080/api/todos/${id}`)
      .subscribe(() => {
        this.todos = this.todos.filter(todo => todo.id !== id);
      });
  }
}
