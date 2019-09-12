import java.io.IOException;
/**
 * The child class of Command class which mark the corresponding object as done when input is [delete]+num
 */
public class DeleteCommand extends Command {
    private int num;
    public DeleteCommand(int i){
        this.num = i;
    }
    @Override
    /**
     * delete corresponding task from the list and also delete it in the external txt file
     * @param task the current list of the users' task objects
     * @param ui the user interface which defines the output based on different input
     * @param storage the object that handles actions like reading from and writing into the external file
     */
    public void execute(TaskList task, Ui ui, Storage storage) throws IOException {
        if(num>task.size()||num<0){
            System.out.println(Message.OUT_OF_BOUNDS);
        }else{
            ui.delete(task.get(num));
            task.remove(this.num);
        }
        ui.showTotal(task);
        storage.writeInto();
    }
}
