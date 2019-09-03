import java.util.Date;

public class Event extends Task{
//    protected String period;
//    protected Date date;

    public Event(String description, String by){
        super(description);
        this.period = by;
        this.type="E";
    }

    @Override

    public String toString() {
        return "[E]["+ this.getStatusIcon() +"] " + super.toString() + " (at: " + period + ")";
    }
}
