package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.data.IdSequencers;
import se.ecutb.data.TodoRepository;
import se.ecutb.dto.TodoDto;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoDtoConversionService todoDtoConversionService;
    @Autowired
    private CreateTodoService createTodoService;
    @Autowired
    private IdSequencers idSequencers;

    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine, Person assignee) {
        return todoRepository.persist(createTodoService.createTodo(taskDescription,deadLine,assignee));
    }

    @Override
    public TodoDto findById(int todoId) throws IllegalArgumentException {
        return todoRepository.findById(todoId)
                .map(todo -> new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone()))
                .get();
    }

    @Override
    public List<TodoDto> findByTaskDescription(String taskDescription) {
        return todoRepository.findByTaskDescriptionContains(taskDescription).stream()
                .map(todo -> new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> findByDeadLineBefore(LocalDate endDate) {
        return todoRepository.findByDeadLineBefore(endDate).stream()
                .map(todo -> new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> findByDeadLineAfter(LocalDate startDate) {
        return todoRepository.findByDeadLineAfter(startDate).stream()
                .map(todo -> new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> findByDeadLineBetween(LocalDate startDate, LocalDate endDate) {
        return todoRepository.findByDeadLineBetween(startDate,endDate).stream()
                .map(todo -> new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> findAssignedTasksByPersonId(int personId) {
        return todoRepository.findByAssigneeId(personId).stream()
                .map(todo -> new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> findUnassignedTasks() {
        return todoRepository.findAllUnassignedTasks().stream()
                .map(todo -> new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> findAssignedTasks() {
        return todoRepository.findAllAssignedTasks().stream()
                .map(todo -> new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> findByDoneStatus(boolean done) {
        return todoRepository.findByDone(done).stream()
                .map(todo -> new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> findAll() {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoDto(todo.getTodoId(),todo.getTaskDescription(),todo.getDeadLine(),todo.getAssignee().getPersonId(),todo.isDone()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(int todoId) throws IllegalArgumentException {
        if(!todoRepository.findById(todoId).isPresent()){
            throw new IllegalArgumentException();
        }
        return todoRepository.delete(todoId);
    }
}
