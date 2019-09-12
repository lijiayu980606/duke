/**
 * A child class of Command which returns all relevant search result when the input is [find]+search key words
 */
public class FindCommand extends Command {
    private String key;
    public FindCommand(String str){
        this.key = str;
    }
    @Override
    /**
     * find all relevant results and store them in a separate list
     * @param task the current list of the users' task objects
     * @param ui the user interface which defines the output based on different input
     * @param storage the object that handles actions like reading from and writing into the external file
     */
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
