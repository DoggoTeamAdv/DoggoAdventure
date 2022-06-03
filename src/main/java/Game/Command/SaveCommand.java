package Game.Command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class SaveCommand implements Command {
    File textfile = new File("src/main/java/userData.txt");
    LinkedList<String> saveData = new LinkedList<String>();


    public SaveCommand(LinkedList<String> list) {
        this.saveData = list;

    }

    public String save() throws IOException {
        int i = 0;
        FileWriter saveFile = new FileWriter(textfile);

        for(i=0; i< saveData.size(); i++){
            saveFile.write(saveData.get(i) + "\n");
        }
        saveFile.close();

        return "Saved Successfully";
    }


    public String execute() throws IOException {
        return save();
    }
}
