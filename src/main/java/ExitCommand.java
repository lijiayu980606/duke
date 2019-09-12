import java.io.IOException;
/**
 * The child class of Command class which exit from the Duke
 */
public class ExitCommand extends Command {
    @Override
    /**
     * execute bye function in class Ui
     * @param task the current list of the users' task objects
     * @param ui the user interface which defines the output based on different input
     * @param storage the object that handles actions like reading from and writing into the external file
     */
    public void execute(TaskList task, Ui ui, Storage storage) throws IOException {

       // storage.writeInto();
        ui.bye();
    }
}
