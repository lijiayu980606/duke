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
                Todo cmd = new Todo(description);
                cmd.isDone = (done.equals("1")) ? true : false;
                listCmd.add(cmd);
            } else if (type.equals("D")) {
                String time = lineParts[3];
                Deadline cmd = new Deadline(description,time);
                cmd.isDone = (done.equals("1")) ? true : false;
                //cmd.setPeriod(lineParts[3]);cmdl.setDate(formatter.parse(lineParts[3]));

                listCmd.add(cmd);
            } else {
                String time = lineParts[3];
                Event cmd = new Event(description,time);
                cmd.isDone = (done.equals("1")) ? true : false;
//                cmd.setDate(formatter.parse(lineParts[3]));
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
                    Task cmd = listCmd.get(i);
                    System.out.println("    "+num+". "+ cmd);
                }
                System.out.println("    --------------------------------------------------------");
            }else if (type.equals("done")) {
                System.out.println("    --------------------------------------------------------");
                //System.out.println(scCmd.next());
                int i =Integer.parseInt(scCmd.next())-1;
                listCmd.get(i).markAsDone();
                System.out.println("    Nice! I've marked this task as done:\n"+"    [" + listCmd.get(i).getStatusIcon()+"] "+listCmd.get(i).description);
                System.out.println("    --------------------------------------------------------");
            }else if(type.equals("find")){
                List<Task> results = new ArrayList<>();
                String search = scCmd.next();
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
            }else if(type.equals("todo")) {
                System.out.println("    --------------------------------------------------------");
                try{
                    if(scCmd.hasNext()){
                        Todo td = new Todo(scCmd.nextLine());
                        listCmd.add(td);
                        System.out.println("    Got it. I've added this task: ");
                        System.out.println("    [T][\u2718]"+ td.description);
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
                String description = ddlSc.next();
                String period = ddlSc.next();
                Deadline ddl = new Deadline(description,period);
                String[] parts = period.split("/");
                if(parts.length==3){
                    Date dateDdl = formatter.parse(period);
                    ddl.period = dateDdl.toString();
                }
                listCmd.add(ddl);
                listCmd.get(listCmd.size()-1).period=ddl.period;
                System.out.println("    Got it. I've added this task: ");
                System.out.println("    [D][\u2718]"+ ddl.description+" (by: "+ddl.period+")");
                System.out.println("    Now you have "+ listCmd.size()+" tasks in the list.");
                System.out.println("    --------------------------------------------------------");
            }else if(type.equals("event")){
                String ddlCmd = scCmd.nextLine();
                Scanner ddlSc = new Scanner(ddlCmd).useDelimiter("\\s*/at\\s*");
                String description = ddlSc.next();
                String period = ddlSc.next();
                Event event = new Event(description,period);
                String[] parts = period.split("/");
                if(parts.length==3) {
                    Date dateEvent = formatter.parse(period);
                    event.period = dateEvent.toString();
                }
       //         event.setDate(dateEvent);
                listCmd.add(event);
                listCmd.get(listCmd.size()-1).period=event.period;
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
                out.write("D|"+ done +"|"+ listCmd.get(i).description+ "|"+listCmd.get(i).getPeriod()+"\n");
            }else{
                out.write("E|"+ done +"|"+ listCmd.get(i).description+ "|"+listCmd.get(i).getPeriod()+"\n");
            }
        }
        out.flush();
        out.close();
    }
}

