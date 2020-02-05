package se.ecutb.service;

import org.springframework.stereotype.Component;
import se.ecutb.dto.TodoDto;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.time.LocalDate;
import java.util.List;
@Component
public class TodoServiceImpl implements TodoService {
    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine, Person assignee) {
        return null;
    }

    @Override
    public TodoDto findById(int todoId) throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<TodoDto> findByTaskDescription(String taskDescription) {
        return null;
    }

    @Override
    public List<TodoDto> findByDeadLineBefore(LocalDate endDate) {
        return null;
    }

    @Override
    public List<TodoDto> findByDeadLineAfter(LocalDate startDate) {
        return null;
    }

    @Override
    public List<TodoDto> findByDeadLineBetween(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public List<TodoDto> findAssignedTasksByPersonId(int personId) {
        return null;
    }

    @Override
    public List<TodoDto> findUnassignedTasks() {
        return null;
    }

    @Override
    public List<TodoDto> findAssignedTasks() {
        return null;
    }

    @Override
    public List<TodoDto> findByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public List<TodoDto> findAll() {
        return null;
    }

    @Override
    public boolean delete(int todoId) throws IllegalArgumentException {
        return false;
    }
}
