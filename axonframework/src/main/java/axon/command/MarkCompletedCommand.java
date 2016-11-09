package axon.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * @author WanChuanLai
 * @create 7/26/16.
 *  2,完成命令
 */
public class MarkCompletedCommand {
    @TargetAggregateIdentifier
    private final String todoId;

    public MarkCompletedCommand(String todoId) {
        System.out.println("1111-come MarkCompletedCommand MarkCompletedCommand");
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}
