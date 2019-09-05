import java.io.IOException;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) throws IOException {

       // storage.writeInto();
        ui.bye();
    }
}
