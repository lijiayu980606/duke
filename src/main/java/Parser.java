import java.util.Scanner;

public class Parser {
    protected String cmd;
    protected String type;


    public static Command parse(String line) throws DukeException {
        String type =type(line);
        String cmd;

        switch (type){
            case"bye": {return new ExitCommand();}//ok
            case"list": {return new ListCommand();}//ok
            case"done": {
                cmd =line.strip().split(" ")[1];
                int i = Integer.parseInt(cmd.strip())-1;
                return new DoneCommand(i);
            }//ok
            case"delete": {
                cmd =line.strip().split(" ")[1];
                int i = Integer.parseInt(cmd.strip())-1;
                return new DeleteCommand(i);
            }//ok
            case"find": {
                cmd =line.strip().split(" ")[1];
                String key = cmd.strip();
                return new FindCommand(key);
            }//ok
            case"todo": {
                cmd =line.strip().split(" ")[1];
                return new TodoCommand(line);
            }
            case"deadline": {
                cmd =line.strip().split(" ")[1];
                return new DeadlineCommand(line);
            }
            case"event": {
                cmd =line.strip().split(" ")[1];
                return new EventCommand(line);
            }
            default:
                throw new DukeException(Message.UNKNOWN);
        }
    }
    private static String type(String ipt) {
        return ipt.strip().split(" ")[0];
    }

}
