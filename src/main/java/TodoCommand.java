import java.io.IOException;
import java.util.Scanner;
/**
 * The child class of Command class which stores a td data type into the tasklist
 */
public class TodoCommand extends Command {
    private String cmd;
    private String dummy;
    public TodoCommand(String str){
        Scanner sc = new Scanner(str);
        this.dummy = sc.next();
        this.cmd = sc.nextLine();
    }
    @Override
    /**
     * execute function in class UI and store it into a tasklist
     * @param task the current list of the users' task objects
     * @param ui the user interface which defines the output based on different input
     * @param storage the object that handles actions like reading from and writing into the external file
     */
     public void execute(TaskList task, Ui ui, Storage storage) throws IOException {
        Todo td = new Todo(this.cmd);
        task.add(td);
        ui.todo(td);
        storage.writeInto();
        ui.showTotal(task);
    }
}
