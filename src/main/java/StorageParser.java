public class StorageParser {
    //read file
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
