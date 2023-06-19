package com.SoftwareMind.SoftwareMindApp.service;

import com.SoftwareMind.SoftwareMindApp.model.ToDo;
import com.SoftwareMind.SoftwareMindApp.repository.ToDoRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public ToDo getToDoById(Long id) {
        return toDoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo not found"));
    }

    public ToDo createToDo(ToDo toDo) {
        if(toDo.getTitle().isEmpty()){
            throw new NoSuchElementException();}
        return toDoRepository.save(toDo);


    }

    public ToDo updateToDo(Long id, ToDo todoDetails) {
        ToDo toDo = getToDoById(id);
        toDo.setTitle(todoDetails.getTitle());
        toDo.setDescription(todoDetails.getDescription());
        toDo.setCompleted(todoDetails.isCompleted());
        return toDoRepository.save(toDo);
    }

    public void deleteToDo(Long id) {
        ToDo toDo = getToDoById(id);
        toDoRepository.delete(toDo);
    }
}
