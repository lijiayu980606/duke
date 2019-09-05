import java.io.IOException;

public class DeleteCommand extends Command {
    private int num;
    public DeleteCommand(int i){
        this.num = i;
    }
    @Override
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
