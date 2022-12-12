package woojcoding.todoapp.Todo;

import lombok.Getter;

public enum ExceptionCode {
    TODO_NOT_FOUND(404, "Todo not found"),
    TODO_EXISTS(409, "TODO EXISTS");

    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
