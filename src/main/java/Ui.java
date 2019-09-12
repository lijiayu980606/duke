import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * defined many user inputs
 */
public class Ui {
    protected Scanner sc;
//    protected Scanner scCmd;
//    protected String input;
//    protected String type;
    protected SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy HHmm");;
    public Ui(){
        sc = new Scanner(System.in);
//        this.input = sc.nextLine();
//        this.scCmd = new Scanner(input);
//        this.type = scCmd.next();
    }

    /**
     * read the next line of input
     * @return a string of input
     */
    public String read() {
        String line = sc.nextLine().strip();
        System.out.println("\n" + line);
        return line;
    }

    /**
     * greet the users
     */
    public void greeting(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("    Hello! I'm Duke\n" + "    What can I do for you?");

    }

    /**
     * exit from the duke
     */
    public void bye(){

        System.out.println("    Bye. Hope to see you again soon!");

    }

    /**
     * list out all items
     * @param listCmd a list of Tasks
     */
    public void list(List<Task> listCmd){

        int sizeCommand = listCmd.size();
        for(int i = 0; i < sizeCommand; i++){
            int num=i+1;
            Task cmd = listCmd.get(i);
            System.out.println("    "+num+". "+ cmd);
        }

    }

    /**
     * mark the status of the tsk as done
     * @param tsk
     */
    public void done(Task tsk){

        System.out.println("    Nice! I've marked this task as done:\n"+"    " +tsk );

    }

    /**
     * delete a task from the list
     * @param tsk
     */
    public void delete(Task tsk){

        System.out.println("    Noted. I've removed this task:\n"+"    " + tsk);

    }
    /**
     * find for a task with key words
     * @param task a list of Tasks
     */
    public void find(TaskList task){

        int sizeCommand = task.size();
        for(int i = 0; i < sizeCommand; i++){
            int num=i+1;
            Task cmd = task.get(i);
            System.out.println("    "+num+". "+ cmd);
        }
    }

    /**
     * output when a task is added
     * @param task
     */
    public void showAdd(Task task) {
        System.out.println("    Got it. I've added this task:\n" + task);
    }

    /**
     * store a task as a todotask
     * @param tsk
     */
    public void todo(Task tsk){

        System.out.println("    Got it. I've added this task: "+tsk);

    }
    /**
     * store a task as a deadline task
     * @param tsk
     */
    public void deadline(Task tsk) {

        System.out.println("    Got it. I've added this task: "+tsk);

    }
    /**
     * store a task as an event task
     * @param tsk
     */
    public void event(Task tsk) {

        System.out.println("    Got it. I've added this task: "+tsk);

    }

    /**
     * show errors while loading
     * @param e
     */
    public void showLoadingError(DukeException e) {
        System.out.println("OOPS, loading failed!"+ e);
    }

    /**
     * show total numbers of tasks in the tasklist
     * @param task
     */
    public void showTotal(TaskList task){

        System.out.println("    Now you have "+ task.size()+" tasks in the list.");

    }

    /**
     * show seperation lines
     */
    public void showLine() {
        System.out.println("    --------------------------------------------------------");
    }
}
