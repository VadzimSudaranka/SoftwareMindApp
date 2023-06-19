import { Component, OnInit } from '@angular/core';
import { ToDo } from './todo.model';
import { TodoService } from './todo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  todos: ToDo[] = [];

  constructor(private todoService: TodoService) { }

  ngOnInit() {
    this.loadTodos();
  }

  loadTodos() {
    this.todoService.getAllTodos().subscribe(
      todos => this.todos = todos,
      error => console.log(error)
    );
  }
}
