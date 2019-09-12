import java.util.List;
/**
 * The child class of Command class which list out all items in the task list when input is list
 */
public class ListCommand extends Command {
    @Override
    /**
     * execute list function in class UI and list out all current items
     * @param task the current list of the users' task objects
     * @param ui the user interface which defines the output based on different input
     * @param storage the object that handles actions like reading from and writing into the external file
     */
     public void execute(TaskList task,Ui ui, Storage storage) {
        ui.list(task);
    }
}
