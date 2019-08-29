import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Duke {
    //level 6
    public static void main(String[] args) throws IOException, ParseException {
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

        Path file = Paths.get("duke.txt");
        FileWriter out = new FileWriter(String.valueOf(file),true);
        Scanner sc = new Scanner(file);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");

        while(sc.hasNext()) {
            String nextLine = sc.nextLine();
            String[] lineParts = nextLine.split("\\|");
            String type = lineParts[0];
            String done = lineParts[1];
            String description = lineParts[2];
            if (type.equals("T")) {
                Task cmd = new Task(description);
                cmd.isDone = (done.equals("1")) ? true : false;
                cmd.type = "T";
                listCmd.add(cmd);
            } else if (type.equals("D")) {
                Task cmd = new Task(description);
                cmd.isDone = (done.equals("1")) ? true : false;
                cmd.type = "D";
                cmd.setPeriod(lineParts[3]);
                cmd.setDate(formatter.parse(lineParts[3]));
                listCmd.add(cmd);
            } else {
                Task cmd = new Task(description);
                cmd.isDone = (done.equals("1")) ? true : false;
                cmd.type = "E";
                cmd.setPeriod(lineParts[3]);
                cmd.setDate(formatter.parse(lineParts[3]));
                listCmd.add(cmd);
            }
        }

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
                try{
                    if(scCmd.hasNext()){
                        Task todo = new Task(scCmd.nextLine());
                        listCmd.add(todo);
                        System.out.println("    Got it. I've added this task: ");
                        System.out.println("    [T][\u2718]"+ todo.description);
                        System.out.println("    Now you have "+ listCmd.size()+" tasks in the list.");
                    }else{
                        throw new DukeException("The description of a todo cannot be empty.");
                    }
                }catch (DukeException exception){
                    System.out.println("    \u2639 OOPS!!! " + exception.getMessage());
                }
                System.out.println("    --------------------------------------------------------");
            }else if(type.equals("deadline")) {
                System.out.println("    --------------------------------------------------------");
                String ddlCmd = scCmd.nextLine();
                Scanner ddlSc = new Scanner(ddlCmd).useDelimiter("\\s*/by\\s*");
                Task ddl = new Task(ddlSc.next());
                String period = ddlSc.next();
                ddl.setPeriod(period);
                Date dateDdl = formatter.parse(period);
                ddl.setDate(dateDdl);
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
                String period = evtSc.next();
                event.setPeriod(period);
                Date dateEvt = formatter.parse(period);
                event.setDate(dateEvt);
                event.taskEvent();
                listCmd.add(event);
                System.out.println("    Got it. I've added this task: ");
                System.out.println("    [E][\u2718]"+ event.description +" (at: "+event.period+")");
                System.out.println("    Now you have "+ listCmd.size()+" tasks in the list.");
                System.out.println("    --------------------------------------------------------");
            }else{
                System.out.println("    --------------------------------------------------------");
                System.out.println("    \u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println("    --------------------------------------------------------");
            }
        }
        new FileWriter("duke.txt").close();
        int sizeCommand = listCmd.size();
        for(int i = 0; i < sizeCommand; i++){
            String done = listCmd.get(i).isDone?"1":"0";
            if(listCmd.get(i).type.equals("T")){
                out.write("T|"+ done +"|"+ listCmd.get(i).description+"\n");
            }else if(listCmd.get(i).type.equals("D")){
                out.write("D|"+ done +"|"+ listCmd.get(i).description+ "|"+listCmd.get(i).period+"\n");
            }else{
                out.write("E|"+ done +"|"+ listCmd.get(i).description+ "|"+listCmd.get(i).period+"\n");
            }
        }
        out.flush();
        out.close();
    }
}

