import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 * The child class of Command class which store an item event in the list input is [event]+task+[/at]+time
 */
public class EventCommand extends Command {
    private String cmd;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
    public EventCommand(String str){
        this.cmd = str;
    }
    /**
     * read and store the event object into the Task List
     * @param task the current list of the users' task objects
     * @param ui the user interface which defines the output based on different input
     * @param storage the object that handles actions like reading from and writing into the external file
     */
    public void execute(TaskList task, Ui ui, Storage storage) throws ParseException, IOException, DukeException {
        String[] context = cmd.substring("deadline".length()).strip().split("/at");
        if (context.length != 2 || context[1] == null) {
            throw new DukeException(Message.INVALID_FORMAT);
        }
        if (context[0].strip().isEmpty()) {
            throw new DukeException(Message.EMPTY);
        }
        String description = context[0].strip();
        String period = context[1].strip();
        Event evt = new Event(description,period);
        String[] parts = period.split("/");
        if(parts.length==3){
            Date dateEvt = formatter.parse(period);
            evt.period = dateEvt.toString();
        }
        task.add(evt);
        //storage.writeInto();
        ui.event(evt);
        ui.showTotal(task);
    }
}
