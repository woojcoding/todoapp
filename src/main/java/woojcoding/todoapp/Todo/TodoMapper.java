package woojcoding.todoapp.Todo;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TodoMapper {
    Todo todoPostDtoToTodos(TodoDto.Post requestbody);
    Todo todoPatchDtoToTodos(TodoDto.Patch requestbody);
    TodoDto.Response todoToTodoResponseDto(Todo todo);
    List<TodoDto.Response> todosToTodoResponseDtos(List<Todo> todos);
}
