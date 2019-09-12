import java.util.Date;

/**
 * Class Task defines object type Class which stores the task's type/status/content etc.
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;
    protected String period;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * This function gets the status of the task and return the corresponding icon
     * @return an icon string which indicates the status of the task
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * This function will mark an undone task as done
     */
    public void markAsDone(){
        this.isDone = true;
    }

    /**
     * This function gets the period String of the task
     * @return period which is s String that indicates the time period set for this task
     */
    public String getPeriod(){return this.period;}
    /**
     * This function sets the period String of the task
     */
    public void setPeriod(String period) {
        this.period = period;
    }
    /**
     * This function return a string in a certain format
     * @return a String can be directly printed by the list command
     */
    public String toString() {
        return this.description;
    }
}