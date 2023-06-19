package com.SoftwareMind.SoftwareMindApp.repository;

import com.SoftwareMind.SoftwareMindApp.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}