package woojcoding.todoapp.Todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;


    public Todo createTodo(Todo todo) {
        Todo savedTodo = todoRepository.save(todo);

        return savedTodo;
    }
    @Transactional(readOnly = true)
    public Todo findTodo(int todoId) {
        Todo findTodo = findVerifiedTodo(todoId);
        return findTodo;
    }

    public Todo updateTodo(Todo todo) {
        Todo findTodo = findVerifiedTodo(todo.getId());

        Optional.ofNullable(todo.getTitle())
                .ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(todo.getTodoOrder())
                .ifPresent(order -> findTodo.setTodoOrder(order));
        Optional.ofNullable(todo.isCompleted())
                .ifPresent(completed->findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }

    public void deleteTodo(int todoId) {
        Todo findTodo = findVerifiedTodo(todoId);
        todoRepository.delete(findTodo);
    }
    @Transactional(readOnly = true)
    public Todo findVerifiedTodo(int todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        Todo findTodo = optionalTodo.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));
        return findTodo;
    }

    public List<Todo> findTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos;
    }
}
