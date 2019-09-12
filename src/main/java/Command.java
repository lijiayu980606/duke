import java.io.IOException;
import java.text.ParseException;

/**
 * Abstract class that execute different commands
 */
public abstract class Command {
    /**
     * Execute the corresponding command
     *
     * @param ui the user interface which defines the output based on different input
     * @param task the current list of the users' task objects
     * @param storage the object that handles actions like reading from and writing into the external file
     */
    public abstract void execute(TaskList task, Ui ui, Storage storage) throws ParseException, DukeException, IOException, ParseException;
}
