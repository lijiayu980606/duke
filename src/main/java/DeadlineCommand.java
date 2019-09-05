import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DeadlineCommand extends Command {
    private String cmd;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
    public DeadlineCommand(String str){
        this.cmd = str;
    }
    @Override
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
