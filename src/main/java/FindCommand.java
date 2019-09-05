public class FindCommand extends Command {
    private String key;
    public FindCommand(String str){
        this.key = str;
    }
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        TaskList results = new TaskList();
        for(int i = 0; i < task.size(); i++){
            if(task.get(i).description.contains(this.key)){
                Task cmd = task.get(i);
                results.add(cmd);
            }
        }
        ui.find(results);
    }
}
