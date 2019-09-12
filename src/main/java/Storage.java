import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class stores and read data from a txt file
 */
public class Storage{
    private String file;
    private List<Task> listCmd;
    private Ui ui;

    public Storage(String path, Ui ui) throws FileNotFoundException {
        this.file = path;
        this.ui = ui;
        readFrom();
    }

    /**
     * update listCmd to current list of tasks before storing it
     * @param tasks
     */
    public void update(TaskList tasks){
        if(!tasks.isEmpty()) {
            listCmd.clear();
            for (int i = 0; i < tasks.size(); i++) {
                listCmd.add(tasks.get(i));
            }
        }
    }

    /**
     * read from an existing txt file
     * @return tsk which is a TaskList with all stored command being written into it
     * @throws FileNotFoundException
     */
    public List<Task> readFrom() throws FileNotFoundException {
        List<Task> tsk = new ArrayList<>();
            File f = new File(file);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                tsk.add(StorageParser.takeTaskFromFile(s.nextLine()));
            }
            s.close();
        listCmd = tsk;
        return tsk;
    }

    /**
     *write into an existing .txt file
     * @throws IOException
     */
    public void writeInto() throws IOException {
        Path file = Paths.get("duke.txt");
        FileWriter out = new FileWriter(String.valueOf(file),false);
        int sizeCommand = listCmd.size();
        for(int i = 0; i < sizeCommand; i++){
            out.write(StorageParser.writeCmdAsString(listCmd.get(i)));
        }
        out.flush();
        out.close();
    }

    /**
     * expose listCmd for other classes to get access to it
     * @return
     */
    public List<Task> get (){
        return this.listCmd;
    }
}