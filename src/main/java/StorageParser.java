/**
 * This class defines a few basic operations that we would be using while reading from or writing into a text file.
 */
public class StorageParser {
    //read file

    /**
     * this function read from the txt file and transfer the lines into task objects
     * @param nextLine pass in the command line and turns it into a task object
     * @return Task which is storable in a TaskList type of list
     */
    public static Task takeTaskFromFile(String nextLine){
        String[] lineParts = nextLine.split("\\|");
        String type = lineParts[0];
        String done = lineParts[1];
        String description = lineParts[2];

        //System.out.println(lineParts[0]);
        //System.out.println(lineParts[1]);
       //System.out.println(lineParts[2]);
        //System.out.println(lineParts[3]);
        if (type.equals("T")) {
            Todo cmd = new Todo(description);
            cmd.isDone = (done.equals("1")) ? true : false;
            return  cmd;
        } else if (type.equals("D")) {
            String time = lineParts[3];
            Deadline cmd = new Deadline(description,time);
            cmd.isDone = (done.equals("1")) ? true : false;
            return  cmd;
        } else {
            String time = lineParts[3];
            Event cmd = new Event(description,time);
            cmd.isDone = (done.equals("1")) ? true : false;
            return  cmd;
        }
    }

    /**
     * this function transfer task objects into strings and write them into the txt file
     * @param cmd a Task object
     * @return A string that can be stored in a txt file
     */
    //write file
    public static String writeCmdAsString(Task cmd){
        String done = cmd.isDone?"1":"0";
        if(cmd.type.equals("T")){
            return "T|"+ done +"|"+ cmd.description+"\n";
        }else if(cmd.type.equals("D")){
            return "D|"+ done +"|"+ cmd.description+ "|"+cmd.getPeriod()+"\n";
        }else{
            return "E|"+ done +"|"+ cmd.description+ "|"+cmd.getPeriod()+"\n";
        }
    }
}
