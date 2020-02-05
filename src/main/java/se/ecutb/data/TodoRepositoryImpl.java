package se.ecutb.data;

import se.ecutb.model.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class TodoRepositoryImpl implements TodoRepository {
    @Override
    public Todo persist(Todo todo) {
        return null;
    }

    @Override
    public Optional<Todo> findById(int todoId) {
        return Optional.empty();
    }

    @Override
    public List<Todo> findByTaskDescriptionContains(String taskDescription) {
        return null;
    }

    @Override
    public List<Todo> findByDeadLineBefore(LocalDate endDate) {
        return null;
    }

    @Override
    public List<Todo> findByDeadLineAfter(LocalDate startDate) {
        return null;
    }

    @Override
    public List<Todo> findByDeadLineBetween(LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public List<Todo> findByAssigneeId(int personId) {
        return null;
    }

    @Override
    public List<Todo> findAllUnassignedTasks() {
        return null;
    }

    @Override
    public List<Todo> findAllAssignedTasks() {
        return null;
    }

    @Override
    public List<Todo> findByDone(boolean isDone) {
        return null;
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public boolean delete(int todoId) throws IllegalArgumentException {
        return false;
    }

    @Override
    public void clear() {

    }
}
