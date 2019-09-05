import java.util.List;

public class ListCommand extends Command {
    @Override
     public void execute(TaskList task,Ui ui, Storage storage) {
        ui.list(task);
    }
}
