import java.io.IOException;
import java.util.Scanner;

public class TodoCommand extends Command {
    private String cmd;
    private String dummy;
    public TodoCommand(String str){
        Scanner sc = new Scanner(str);
        this.dummy = sc.next();
        this.cmd = sc.nextLine();
    }
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) throws IOException {
        Todo td = new Todo(this.cmd);
        task.add(td);
        ui.todo(td);
        storage.writeInto();
        ui.showTotal(task);
    }
}
