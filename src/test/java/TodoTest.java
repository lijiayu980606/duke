import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoTest {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    @Test
    public void test () throws DukeException, IOException, ParseException {
        ui = new Ui();
        try {
            storage = new Storage("duke.txt",ui);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File f = new File("duke.txt");
        tasks = new TaskList();
        try {
            if(f.exists()) {
                //tasks = new TaskList();
                List<Task> readed = storage.readFrom();
                for(int i = 0 ; i < readed.size(); i++){
                    tasks.add(readed.get(i));
                }
            }else{
                throw new DukeException("Oops! Could not find file!");
            }
        } catch (DukeException | FileNotFoundException e) {
            ui.showLoadingError((DukeException) e);
            //tasks = new TaskList();
        }
        //Task task = new Todo(" JUnitTesting");
        String fullCommand = ("todo JUnitTesting");
        Command c = Parser.parse(fullCommand);
        c.execute(tasks, ui, storage);

        Todo td = new Todo("JUnitTesting");
       // storage.update(tasks);
        ui.list(tasks);
        System.out.println(td.toString());
        assertTrue(tasks.get(tasks.size()-1).toString().equals(td.toString()));
    }
}
