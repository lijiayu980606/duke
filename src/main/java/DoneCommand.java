import java.io.IOException;

public class DoneCommand extends Command{
    private int num;
    public DoneCommand(int i){
        this.num=i;
    }
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) throws IOException {
        if(num>task.size()||num<0){
            System.out.println(Message.OUT_OF_BOUNDS);
        }else{
            task.get(num).markAsDone();
        }
        ui.done(task.get(num));
        storage.writeInto();
    }
}
