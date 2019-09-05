import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
    //ok
    public String read() {
        String line = sc.nextLine().strip();
        System.out.println("\n" + line);
        return line;
    }
    //ok
    public void greeting(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("    Hello! I'm Duke\n" + "    What can I do for you?");

    }
    //ok
    public void bye(){

        System.out.println("    Bye. Hope to see you again soon!");

    }
    //ok
    public void list(List<Task> listCmd){

        int sizeCommand = listCmd.size();
        for(int i = 0; i < sizeCommand; i++){
            int num=i+1;
            Task cmd = listCmd.get(i);
            System.out.println("    "+num+". "+ cmd);
        }

    }
//ok
    public void done(Task tsk){

        System.out.println("    Nice! I've marked this task as done:\n"+"    " +tsk );

    }
//ok
    public void delete(Task tsk){

        System.out.println("    Noted. I've removed this task:\n"+"    " + tsk);

    }
/*
    public void find(List<Task> listCmd){
 //       List<Task> results = new ArrayList<>();
 //       String search = scCmd.next();
        for(int i = 0; i < listCmd.size(); i++){
            if(listCmd.get(i).description.contains(search)){
                Task cmd = listCmd.get(i);
                results.add(cmd);
            }
        }
        System.out.println("    --------------------------------------------------------");
        System.out.println("    Here are the matching tasks in your list:");
        for(int i = 0; i < results.size(); i++){
            int num=i+1;
            Task cmd = results.get(i);
            System.out.println("    "+num+". "+ cmd);
        }
        System.out.println("    --------------------------------------------------------");
    }
 */
    public void find(TaskList task){

        int sizeCommand = task.size();
        for(int i = 0; i < sizeCommand; i++){
            int num=i+1;
            Task cmd = task.get(i);
            System.out.println("    "+num+". "+ cmd);
        }

    }//ok
    public void showAdd(Task task) {
        System.out.println("    Got it. I've added this task:\n" + task);
    }
    public void todo(Task tsk){

        System.out.println("    Got it. I've added this task: "+tsk);

    }//ok

    public void deadline(Task tsk) {

        System.out.println("    Got it. I've added this task: "+tsk);

    }//ok

    public void event(Task tsk) {

        System.out.println("    Got it. I've added this task: "+tsk);

    }

    public void showLoadingError(DukeException e) {
        System.out.println("OOPS, loading failed!"+ e);
    }
    public void showTotal(TaskList task){

        System.out.println("    Now you have "+ task.size()+" tasks in the list.");

    }
    public void showLine() {
        System.out.println("    --------------------------------------------------------");
    }
}
