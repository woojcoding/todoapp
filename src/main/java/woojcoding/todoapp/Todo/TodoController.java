package woojcoding.todoapp.Todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper mapper;

    @PostMapping
    public ResponseEntity postTodo(@RequestBody TodoDto.Post requestBody) {
        Todo todo = mapper.todoPostDtoToTodos(requestBody);
        Todo response = todoService.createTodo(todo);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.todoToTodoResponseDto(response)), HttpStatus.CREATED);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id")  int todoId) {
        Todo response = todoService.findTodo(todoId);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.todoToTodoResponseDto(response)), HttpStatus.OK);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") int todoId,
                                    @RequestBody TodoDto.Patch requestBody) {
        requestBody.setId(todoId);
        Todo response = todoService.updateTodo(mapper.todoPatchDtoToTodos(requestBody));
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.todoToTodoResponseDto(response)),HttpStatus.OK);
    }
    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") int todoId) {
        todoService.deleteTodo(todoId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> response = todoService.findTodos();
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.todosToTodoResponseDtos(response)), HttpStatus.OK);
    }
}
