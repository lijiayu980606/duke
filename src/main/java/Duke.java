import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Duke {
    //level 4
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("    --------------------------------------------------------");
        System.out.println("    Hello! I'm Duke\n" + "    What can I do for you?");
        System.out.println("    --------------------------------------------------------");
        List<Task> listCmd = new ArrayList<Task>();
        while(true){
            Scanner myObj = new Scanner(System.in);
            String ipt = myObj.nextLine();
            Scanner scCmd = new Scanner(ipt);
            String type = scCmd.next();
            if(type.equals("bye")){
                System.out.println("    --------------------------------------------------------");
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    --------------------------------------------------------");
                break;
            }else if(type.equals("list")){
                System.out.println("    --------------------------------------------------------");
                int sizeCommand = listCmd.size();
                for(int i = 0; i < sizeCommand; i++){
                    int num=i+1;
                    if(listCmd.get(i).type.equals("T")){
                        System.out.println("    "+ num + ".[" +listCmd.get(i).type+"]"+" ["+ listCmd.get(i).getStatusIcon()+"] "+listCmd.get(i).description);
                    }else if(listCmd.get(i).type.equals("D")){
                        System.out.println("    "+ num + ".[" +listCmd.get(i).type+"]"+" ["+ listCmd.get(i).getStatusIcon()+"] "+listCmd.get(i).description+" (by: "+listCmd.get(i).period+")");
                    }else{
                        System.out.println("    "+ num + ".[" +listCmd.get(i).type+"]"+" ["+ listCmd.get(i).getStatusIcon()+"] "+listCmd.get(i).description+" (at: "+listCmd.get(i).period+")");
                    }
                }
                System.out.println("    --------------------------------------------------------");
            }else if (type.equals("done")) {
                System.out.println("    --------------------------------------------------------");
                //System.out.println(scCmd.next());
                int i =Integer.parseInt(scCmd.next())-1;
                listCmd.get(i).markAsDone();
                System.out.println("    Nice! I've marked this task as done:\n"+"    [" + listCmd.get(i).getStatusIcon()+"] "+listCmd.get(i).description);
                System.out.println("    --------------------------------------------------------");
            }else if(type.equals("todo")) {
                System.out.println("    --------------------------------------------------------");
                Task todo = new Task(scCmd.nextLine());
                listCmd.add(todo);
                System.out.println("    Got it. I've added this task: ");
                System.out.println("    [T][\u2718]"+ todo.description);
                System.out.println("    Now you have "+ listCmd.size()+" tasks in the list.");
                System.out.println("    --------------------------------------------------------");
            }else if(type.equals("deadline")) {
                System.out.println("    --------------------------------------------------------");
                String ddlCmd = scCmd.nextLine();
                Scanner ddlSc = new Scanner(ddlCmd).useDelimiter("\\s*/by\\s*");
                Task ddl = new Task(ddlSc.next());
                ddl.setPeriod(ddlSc.next());
                ddl.taskDeadline();
                listCmd.add(ddl);
                System.out.println("    Got it. I've added this task: ");
                System.out.println("    [D][\u2718]"+ ddl.description+" (by: "+ddl.period+")");
                System.out.println("    Now you have "+ listCmd.size()+" tasks in the list.");
                System.out.println("    --------------------------------------------------------");
            }else if(type.equals("event")){
                System.out.println("    --------------------------------------------------------");
                String evtCmd = scCmd.nextLine();
                Scanner evtSc = new Scanner(evtCmd).useDelimiter("\\s*/at\\s*");
                Task event = new Task(evtSc.next());
                event.setPeriod(evtSc.next());
                event.taskEvent();
                listCmd.add(event);
                System.out.println("    Got it. I've added this task: ");
                System.out.println("    [E][\u2718]"+ event.description +" (at: "+event.period+")");
                System.out.println("    Now you have "+ listCmd.size()+" tasks in the list.");
                System.out.println("    --------------------------------------------------------");
            }
        }
    }
}

