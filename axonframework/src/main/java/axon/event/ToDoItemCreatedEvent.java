package axon.event;

/**
 * @author WanChuanLai
 * @create 7/26/16.
 */

public class ToDoItemCreatedEvent {
    private final String todoId;
    private final String description;

    public ToDoItemCreatedEvent(String todoId, String description) {
        System.out.println("333-come ToDoItemCreatedEvent ToDoItemCreatedEvent");
        this.todoId = todoId;
        this.description = description;
    }

    public String getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }
}
