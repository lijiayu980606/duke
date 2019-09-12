import java.util.Scanner;

/**
 * This class transfer input into its corresponding command datatype
 */
public class Parser {
    protected String cmd;
    protected String type;

    /**
     * return corresponding command based on the type of the input
     * @param line user input without the type word
     * @return Command return a command data type
     * @throws DukeException
     */
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

    /**
     * get the type string of the input command
     * @param ipt user input
     * @return String that represents type of the command
     */
    private static String type(String ipt) {
        return ipt.strip().split(" ")[0];
    }

}
