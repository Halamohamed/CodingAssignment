package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.dto.TodoDto;
import se.ecutb.model.Todo;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoDtoConversionServiceImpl implements TodoDtoConversionService {
    private List<TodoDto> todoDtos= new ArrayList<>();

    @Autowired
    public TodoDtoConversionServiceImpl(List<TodoDto> todoDtos) {
        this.todoDtos = todoDtos;
    }

    @Override
    public TodoDto convertToDto(Todo todo) {
        TodoDto todoDto = null;
        if(todo.getAssignee() != null){
            todoDto = new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone());
        }
        else {
            todoDto = new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),null, todo.isDone());
        }
            todoDtos.add(todoDto);
        return todoDto;
    }
}
