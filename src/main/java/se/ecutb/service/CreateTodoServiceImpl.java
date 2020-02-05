package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.data.IdSequencers;
import se.ecutb.model.AbstractTodoFactory;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateTodoServiceImpl extends AbstractTodoFactory implements CreateTodoService {
    private List<Todo> todos = new ArrayList<>();
    @Autowired
    private IdSequencers idSequencers;
    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine, Person assignee) throws IllegalArgumentException {
        if(taskDescription == null){
            throw new IllegalArgumentException();
        }
        Todo todo = createTodoItem(idSequencers.nextTodoId(),taskDescription,deadLine,assignee);
        todos.add(todo);
        return todo;
    }

    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine) throws IllegalArgumentException {
        if(taskDescription == null){
            throw new IllegalArgumentException();
        }
        Todo todo = createTodoItem(idSequencers.nextTodoId(),taskDescription,deadLine);
        todos.add(todo);
        return todo; }
}
