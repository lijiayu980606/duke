import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EventCommand extends Command {
    private String cmd;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
    public EventCommand(String str){
        this.cmd = str;
    }
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
