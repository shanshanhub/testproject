package axon.event;

/**
 * @author WanChuanLai
 * @create 7/26/16.
 */
public class ToDoItemCompletedEvent {
    private final String todoId;

    public ToDoItemCompletedEvent(String todoId) {
        System.out.println("333-come ToDoItemCompletedEvent ToDoItemCompletedEvent");
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}
