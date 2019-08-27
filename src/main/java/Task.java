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
        this.type = "T";
        this.period=null;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public void markAsDone(){
        this.isDone = true;
    }
    public void taskDeadline(){
        this.type="D";
    }
    public void taskEvent(){
        this.type="E";
    }
    public void setPeriod(String timeString){
        this.period=timeString;
    }

}