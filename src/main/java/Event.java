import java.util.Date;

/**
 * Child class of Task which defines a event
 */
public class Event extends Task{
//    protected String period;
//    protected Date date;

    public Event(String description, String by){
        super(description);
        this.period = by;
        this.type="E";
    }

    @Override
/**
 * return a string in a decided form
 */
    public String toString() {
        return "[E]["+ this.getStatusIcon() +"] " + super.toString() + " (at: " + period + ")";
    }
}
