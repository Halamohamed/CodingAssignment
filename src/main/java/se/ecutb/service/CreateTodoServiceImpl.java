package se.ecutb.service;

import org.springframework.stereotype.Component;
import se.ecutb.data.IdSequencers;
import se.ecutb.model.AbstractTodoFactory;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.time.LocalDate;
@Component
public class CreateTodoServiceImpl extends AbstractTodoFactory implements CreateTodoService {
    private IdSequencers idSequencers;
    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine, Person assignee) throws IllegalArgumentException {
        return createTodoItem(idSequencers.nextTodoId(),taskDescription,deadLine,assignee);
    }

    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine) throws IllegalArgumentException {
        return createTodoItem(idSequencers.nextTodoId(),taskDescription,deadLine);
    }
}
