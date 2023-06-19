package com.SoftwareMind.SoftwareMindApp;

import com.SoftwareMind.SoftwareMindApp.model.ToDo;
import com.SoftwareMind.SoftwareMindApp.repository.ToDoRepository;
import com.SoftwareMind.SoftwareMindApp.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ToDoServiceTest {

    @Mock
    private ToDoRepository toDoRepository;

    @InjectMocks
    private ToDoService toDoService;

    @Test
    public void testCreateToDoWithTitle() {
        ToDo toDo = new ToDo();
        toDo.setTitle("Title");
        Mockito.when(toDoRepository.save(toDo)).thenReturn(toDo);
        ToDo createdToDo = toDoService.createToDo(toDo);
        Mockito.verify(toDoRepository, Mockito.times(1)).save(toDo);
        assertSame(toDo, createdToDo);
    }

    @Test
    public void testCreateToDoWithoutTitle() {
        ToDo toDo = new ToDo();
        toDo.setTitle("");
        assertThrows(NoSuchElementException.class, () -> toDoService.createToDo(toDo));
        Mockito.verify(toDoRepository, Mockito.never()).save(toDo);
    }

    @Test
    public void testUpdateToDo() {
        Long id = 1L;
        ToDo existingToDo = new ToDo();
        existingToDo.setId(id);
        existingToDo.setTitle("Existing Title");
        existingToDo.setDescription("Existing Description");
        existingToDo.setCompleted(false);

        ToDo updatedToDo = new ToDo();
        updatedToDo.setTitle("Updated Title");
        updatedToDo.setDescription("Updated Description");
        updatedToDo.setCompleted(true);

        Mockito.when(toDoRepository.findById(id)).thenReturn(Optional.of(existingToDo));
        Mockito.when(toDoRepository.save(existingToDo)).thenReturn(existingToDo);

        ToDo result = toDoService.updateToDo(id, updatedToDo);

        Mockito.verify(toDoRepository, Mockito.times(1)).findById(id);
        Mockito.verify(toDoRepository, Mockito.times(1)).save(existingToDo);
        assertSame(existingToDo, result);
        assertEquals(updatedToDo.getTitle(), result.getTitle());
        assertEquals(updatedToDo.getDescription(), result.getDescription());
        assertEquals(updatedToDo.isCompleted(), result.isCompleted());
    }
}
