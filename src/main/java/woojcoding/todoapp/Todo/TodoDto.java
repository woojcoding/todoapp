package woojcoding.todoapp.Todo;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class TodoDto {


    @Getter
    public static class Post {
        private String title;
        private int todoOrder;
        private Boolean completed;
    }
    @Getter
    public static class Patch{
        private int id;
        private String title;
        private int todoOrder;
        private Boolean completed;

        public void setId(int id) {
            this.id = id;
        }
    }
    @Getter
    @AllArgsConstructor
    public static class Response{
        private int id;
        private String title;
        private int todoOrder;
        private Boolean completed;
    }
}
