import java.util.Date;

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
    public String toString() {
        return "[D]["+ this.getStatusIcon() +"] " + super.toString() + " (by: " + period + ")";
    }
}
