package axon.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * @author WanChuanLai
 * @create 7/26/16.
 * 1,创建命令
 */
public class CreateToDoItemCommand {
    @TargetAggregateIdentifier
    private final String todoId;
    private final String description;

    public CreateToDoItemCommand(String todoId, String description) {
        System.out.println("1111-come CreateToDoItemCommand CreateToDoItemCommand");
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
