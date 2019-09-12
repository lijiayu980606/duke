import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 * The child class of Command class which store a deadline object in the task list when input is [deadline]+task+[/by]+date
 */
public class DeadlineCommand extends Command {
    private String cmd;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
    public DeadlineCommand(String str){
        this.cmd = str;
    }
    @Override
    /**
     * add a task into the users' list
     * @param task the current list of the users' task objects
     * @param ui the user interface which defines the output based on different input
     * @param storage the object that handles actions like reading from and writing into the external file
     */
    public void execute(TaskList task, Ui ui, Storage storage) throws ParseException, IOException, DukeException {
        //Scanner ddlSc = new Scanner(cmd).useDelimiter("\\s*/by\\s*");
        //String description = ddlSc.next();
        //String period = ddlSc.next();
        String[] context = cmd.substring("deadline".length()).strip().split("/by");
        if (context.length != 2 || context[1] == null) {
            throw new DukeException(Message.INVALID_FORMAT);
        }
        if (context[0].strip().isEmpty()) {
            throw new DukeException(Message.EMPTY);
        }
        String description = context[0];
        String period = context[1];
        Deadline ddl = new Deadline(description,period);
        String[] parts = period.split("/");
        if(parts.length==3){
            Date dateEvt = formatter.parse(period);
            ddl.period = dateEvt.toString();
        }
        task.add(ddl);
        storage.writeInto();
        ui.deadline(ddl);
        ui.showTotal(task);
    }
}
