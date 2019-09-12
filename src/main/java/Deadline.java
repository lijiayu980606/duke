import java.util.Date;
/**
 * Child class of Task which defines a deadline task
 */
public class Deadline extends Task{
//    protected String period;
//    protected Date date;

    public Deadline(String description, String by){
        super(description);
//        this.period = by;
        this.type="D";
        this.period=by;
    }

    @Override
    /**
     * return a string in a decided form
     */
    public String toString() {
        return "[D]["+ this.getStatusIcon() +"] " + super.toString() + " (by: " + period + ")";
    }
}
