import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) throws FileNotFoundException {
        ui = new Ui();
        storage = new Storage(filePath,ui);
        File f = new File(filePath);
        try {
            if(f.exists()) {
                tasks = new TaskList();
                List<Task> readed = storage.readFrom();
                for(int i = 0 ; i < readed.size(); i++){
                    tasks.add(readed.get(i));
                }
            }else{
                throw new DukeException("Oops! Could not find file!");
            }
        } catch (DukeException e) {
            ui.showLoadingError(e);
            tasks = new TaskList();
        }
    }

    public void run() throws IOException {
        ui.greeting();
        ui.showLine();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.read();
                Command c = Parser.parse(fullCommand);
                ui.showLine();
                c.execute(tasks, ui, storage);
                if(c instanceof ExitCommand){
                    isExit=true;
                }
            } catch (DukeException | IOException e) {
                System.out.println(e.getMessage());
            } catch (ParseException e) {
                e.printStackTrace();
            }finally{
                storage.update(tasks);
                storage.writeInto();
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Duke("duke.txt").run();
        }catch(FileNotFoundException e){
            System.out.println("    "+Message.NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


