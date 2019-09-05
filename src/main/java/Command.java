import java.io.IOException;
import java.text.ParseException;

public abstract class Command {
    public abstract void execute(TaskList task, Ui ui, Storage storage) throws ParseException, DukeException, IOException, ParseException;
}
