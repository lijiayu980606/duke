import java.util.Date;

//level3
/*public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public void markAsDone(){
        this.isDone = true;
    }

}*/
//level4
public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;
    protected String period;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public void markAsDone(){
        this.isDone = true;
    }
    public String getPeriod(){return this.period;}

    public void setPeriod(String period) {
        this.period = period;
    }

    public String toString() {
        return this.description;
    }
}