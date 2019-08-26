package seedu.duke;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    //level 1
    /*
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
        while(true){
            Scanner myObj = new Scanner(System.in);
            String command = myObj.nextLine();
            if(command.equals("bye")){
                System.out.println("    --------------------------------------------------------");
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    --------------------------------------------------------");
                break;
            }else{
                System.out.println("    --------------------------------------------------------");
                System.out.println("    "+command);
                System.out.println("    --------------------------------------------------------");
            }
        }
    }*/
    //level 2
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
        List<String> listCommand = new ArrayList<String>();
        while(true){
            Scanner myObj = new Scanner(System.in);
            String command = myObj.nextLine();
            if(command.equals("bye")){
                System.out.println("    --------------------------------------------------------");
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    --------------------------------------------------------");
                break;
            }else if(command.equals("list")){
                System.out.println("    --------------------------------------------------------");
                int sizeCommand = listCommand.size();
                for(int i = 0; i < sizeCommand; i++){
                    int num=i+1;
                    System.out.println("    "+ num + ". " + listCommand.get(i));
                }
                System.out.println("    --------------------------------------------------------");
            }else{
                System.out.println("    --------------------------------------------------------");
                listCommand.add(command);
                System.out.println("    added: "+ command);
                System.out.println("    --------------------------------------------------------");
            }
        }
    }
}
