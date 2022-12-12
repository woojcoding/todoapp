package woojcoding.todoapp.Todo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "todo_order")
    private int todoOrder;

    @Column(name = "completed")
    private boolean completed;

}
