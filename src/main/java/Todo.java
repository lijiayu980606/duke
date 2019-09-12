/**
 * the child class of task that define a datatype "todo"
 */
public class Todo extends Task {
    public Todo(String description){
        super(description);
        this.type="T";
    }
    @Override
    /**
     * transfer the data into a string that could be output directly
     */
    public String toString() {
        return "[T]["+ this.getStatusIcon() +"] " + super.toString() ;
    }
}
